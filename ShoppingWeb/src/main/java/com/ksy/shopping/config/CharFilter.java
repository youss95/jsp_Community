package com.ksy.shopping.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class CharFilter implements Filter {

 @Override
public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
		throws IOException, ServletException {
	 HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;");
		response.setCharacterEncoding("UTF-8");
		
		String fileUri = request.getRequestURI();
		
		if(fileUri.contains(".css")) {
			response.setContentType("text/css; charset=utf-8");
		} else if(fileUri.contains(".js")) {
			response.setContentType("text/js; charset=utf-8");
		}else if(fileUri.contains("image/png")) {
			response.setContentType("image/png");
		}else if(fileUri.contains(".jpg")) {
			response.setContentType("image/jpeg");
		}else {
			response.setContentType("text/html; charset=utf-8");
		}
		
		String username = request.getParameter("username");
		System.out.println("username:"+username);
		
		chain.doFilter(request, response);
	
}
	
}
