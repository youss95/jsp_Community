package com.ksy.animal.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	
	public static void back(HttpServletResponse response, String msg) {
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();

			out.print("<script>");
			out.print("alert('" + msg + "');");
			out.print("history.back();"); //history는 윈도우가 들고있는 객체
			out.print("</script>");
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeSuccess(HttpServletResponse response, String msg) {
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('" + msg + "');");
			out.print("window.location.href='pet/index.jsp';");
			out.print("</script>");
			out.flush();
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ReplyWriteSuccess(HttpServletResponse response, String msg) {
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('" + msg + "');");
			out.print("window.location.href='pet/blog/BlogDetail.jsp';");
			out.print("</script>");
			out.flush();
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void IfNotLogin(HttpServletResponse response, String msg) {
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('" + msg + "');");
			out.print("window.location.href='pet/user/LoginForm.jsp';");
			out.print("</script>");
			out.flush();
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void loginSuccessAtBlog(HttpServletResponse response, String msg) {
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('" + msg + "');");
			out.print("window.location.href='pet/blog/blog.jsp';");
			out.print("</script>");
			out.flush();
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
