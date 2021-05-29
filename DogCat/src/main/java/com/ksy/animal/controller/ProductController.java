package com.ksy.animal.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksy.animal.domain.product.Product;
import com.ksy.animal.domain.product.dto.UploadDto;
import com.ksy.animal.service.ProductService;
import com.ksy.animal.util.Script;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/product")
public class ProductController extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
reqpro(request,response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request,response);		
	}
	
	ProductService productService = new ProductService();
	protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("productList")) {
			List<Product> list =  productService.상품목록();
			System.out.println("list는"+list);
			request.setAttribute("productlist", list);
			
			RequestDispatcher dis =  request.getRequestDispatcher("pet/store/store.jsp");
			dis.forward(request, response);
		}else if(cmd.equals("uploadForm")) {
			response.sendRedirect("pet/store/UploadForm.jsp");
		}else if(cmd.equals("uploadProduct")){
			String directory = request.getServletContext().getRealPath("/uploadStore");
			
			System.out.println("경로"+directory);
			int maxSize = 1024*1024*100;
			
			String encoding = "UTF-8";
			try {
				
				
				MultipartRequest multi =
				new MultipartRequest(request, directory, maxSize, encoding,
						new DefaultFileRenamePolicy());

				String pCategory = multi.getParameter("product_category");
				String pStock1 = multi.getParameter("product_stock");
				String pName = multi.getParameter("product_name");
				String pColor = multi.getParameter("product_color");
				String pSize = multi.getParameter("product_size");
				String pDetail = multi.getParameter("pDetail");
			    String product_price = multi.getParameter("product_price");
			    int pPrice = Integer.parseInt(product_price);
				int pStock = Integer.parseInt(pStock1);
				
				Enumeration files = multi.getFileNames();
				String str = (String)files.nextElement();
				String filename = multi.getOriginalFileName(str); //실제 사용자가 업로드하고자한 파일이름
				String fileRealName = multi.getFilesystemName(str); //실제에 서버에 업로드가된 네임
				
				UploadDto dto = new UploadDto();
				dto.setPCategory(pCategory);
				dto.setPStock(pStock);
				dto.setPName(pName);
				dto.setPColor(pColor);
				dto.setPSize(pSize);
				dto.setPDetail(pDetail);
				dto.setPPrice(pPrice);
				dto.setPfileName(filename);
				dto.setFielRealName(fileRealName);
				System.out.println("dto"+dto);
				int result = productService.업로드(dto);
				if(result==1) {
					Script.writeSuccess(response, "성공");
				} else {
					Script.back(response, "실패");
				}
	}catch(Exception e) {
		e.printStackTrace();
	}
		}
	}
}
