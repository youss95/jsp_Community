package com.ksy.shopping.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksy.shopping.domain.cart.Cart;
import com.ksy.shopping.domain.cart.dto.CartReqDto;
import com.ksy.shopping.service.CartService;
import com.ksy.shopping.util.Script;


@WebServlet("/cart")
public class CartController extends HttpServlet {
	
       
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request,response);
	}
	
	protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
CartReqDto dto = new CartReqDto();
Cart cart = new Cart();
		CartService cartService = new CartService();
		String cmd = request.getParameter("cmd");
		if(cmd.equals("bascket")) {
		int product_no = Integer.parseInt(request.getParameter("product_no"));
		int user_no =Integer.parseInt(request.getParameter("user_no"));
		cart.setProduct_no(product_no);
		cart.setUser_no(user_no);
	
	
		int result = cartService.장바구니(product_no,user_no);
	
	
	
	if(result==1) {
		System.out.println("성공입니다.");
		response.sendRedirect("/ShoppingWeb/product?cmd=jacket");
	}else {
		Script.back(response, "실패");
	}
	}
	}
}