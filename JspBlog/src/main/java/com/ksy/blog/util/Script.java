package com.ksy.blog.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

//자바스크립트는 import를 안하고 window.location. 이런식으로 윈도우가 모든 오브젝트를 다 들고있다.

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
}