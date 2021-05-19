package com.ksy.shopping.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Db {
	//DB연결 
	
	public static Connection getCon() {
		try {
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			Connection con = ds.getConnection();
			System.out.println("DB 연결성공");
			return con;
			
		} catch(Exception e) {
			System.out.println("연결실패");
			e.printStackTrace();
		}
	
		return null;
	}
	
	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			con.close();
			pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	public static void close(Connection con,ResultSet rs, PreparedStatement pstmt) {
		try {
			con.close();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
