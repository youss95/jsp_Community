package com.ksy.blog.config;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	//DB연결
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
	
	//접속 종료
	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			con.close();
			pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
}
