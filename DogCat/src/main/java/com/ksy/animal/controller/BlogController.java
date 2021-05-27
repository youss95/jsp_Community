package com.ksy.animal.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ksy.animal.domain.blog.dto.WriteDto;
import com.ksy.animal.domain.user.User;
import com.ksy.animal.domain.user.dto.JoinDto;
import com.ksy.animal.domain.user.dto.LoginDto;
import com.ksy.animal.service.BlogService;
import com.ksy.animal.service.UserService;
import com.ksy.animal.util.Script;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/blog")
public class BlogController extends HttpServlet {
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	reqpro(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request,response);
	}
	BlogService blogService = new BlogService();
	protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("blogList")) {
			
			
			
			response.sendRedirect("pet/blog/blog.jsp");
		}else if(cmd.equals("WriteForm")) {
			response.sendRedirect("pet/blog/WriteForm.jsp");
		}else if(cmd.equals("write")) {
		
			String directory = request.getServletContext().getRealPath("/upload");
			System.out.println("경로"+directory);
int maxSize = 1024*1024*100;
			
			String encoding = "UTF-8";
			try {
				MultipartRequest multi =
						new MultipartRequest(request, directory, maxSize, encoding,
								new DefaultFileRenamePolicy());
				String no = multi.getParameter("user_no");
				int user_no = Integer.parseInt(no);
				System.out.println(user_no);
				String bTitle = multi.getParameter("bTitle");
				String bContent = multi.getParameter("bContent");
				System.out.println("타이틀"+bTitle);
				Enumeration files = multi.getFileNames();
				String str = (String)files.nextElement();
				
				String bfileName = multi.getOriginalFileName(str); //실제 사용자가 업로드하고자한 파일이름
				String bfileRealName = multi.getFilesystemName(str); //실제에 서버에 업로드가된 네임
				
				
				WriteDto dto = new WriteDto();
				
				dto.setUser_no(user_no);
				dto.setBTitle(bTitle);
				dto.setBContent(bContent);
				dto.setBfileName(bfileName);
				dto.setBfileRealName(bfileRealName);
				System.out.println(dto);
				int result = blogService.글쓰기(dto);
				if(result==1) {
					Script.writeSuccess(response, "글쓰기에 성공하였습니다.");
				}else {
					Script.back(response, "글쓰기에 실패하였습니다.");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(cmd.equals("blogList")) {
			
		}
			
		
	}
}
