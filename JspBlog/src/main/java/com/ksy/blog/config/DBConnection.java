package com.ksy.blog.config;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	public static Connection getCon() {
		try {
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			Connection con = ds.getConnection();
			
			return con;
			
		} catch(Exception e) {
			System.out.println("연결실패");
			e.printStackTrace();
		}
	
		return null;
	}
	
}
