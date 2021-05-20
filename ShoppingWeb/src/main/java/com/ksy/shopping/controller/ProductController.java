package com.ksy.shopping.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.io.File;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;

import com.ksy.shopping.domain.product.Product;
import com.ksy.shopping.domain.product.dto.UploadReqDto;
import com.ksy.shopping.domain.user.User;
import com.ksy.shopping.service.ProductService;
import com.ksy.shopping.util.Script;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.Part;


@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request,response);
	}
	
	protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductService productService = new ProductService();
		String cmd = request.getParameter("cmd");
		if(cmd.equals("jacket")){
			List<Product> list =  productService.상품목록보기();
			System.out.println(list);
			request.setAttribute("list", list);
			//sendRedirect로 보내면 request가 사라짐
			RequestDispatcher dis =  request.getRequestDispatcher("product/Mjacket.jsp");
			dis.forward(request, response);
		}else if(cmd.equals("UploadForm")) {
			response.sendRedirect("product/UploadForm.jsp");
		}else if(cmd.equals("upload")) {
		
			
			
			String directory = request.getServletContext().getRealPath("/upload");
		
			System.out.println("경로"+directory);
			int maxSize = 1024*1024*100;
			
			String encoding = "UTF-8";
try {
	
	
			MultipartRequest multi =
			new MultipartRequest(request, directory, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String product_category = multi.getParameter("product_category");
			String product_stock = multi.getParameter("product_stock");
			String product_name = multi.getParameter("product_name");
			String product_color = multi.getParameter("product_color");
			String product_size = multi.getParameter("product_size");
		    String product_price = multi.getParameter("product_price");
			System.out.println("color"+product_color);
			
			
			Enumeration files = multi.getFileNames();
			String str = (String)files.nextElement();
			String filename = multi.getOriginalFileName(str); //실제 사용자가 업로드하고자한 파일이름
			String fileRealName = multi.getFilesystemName(str); //실제에 서버에 업로드가된 네임
			
			UploadReqDto dto = new UploadReqDto();
			dto.setProduct_category(product_category);
			dto.setProduct_stock(product_stock);
			dto.setProduct_name(product_name);
			dto.setProduct_color(product_color);
			dto.setProduct_size(product_size);
			dto.setProduct_price(product_price);
			dto.setFilename(filename);
			dto.setFielRealName(fileRealName);
			System.out.println("업로드"+dto);
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