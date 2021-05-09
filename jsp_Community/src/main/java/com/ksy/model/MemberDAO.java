package com.ksy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void getCon() {
		try {
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			con = ds.getConnection();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberBean> getAllMember(){
		ArrayList<MemberBean> list = new ArrayList<>();
		getCon();
		try {
			String sql="select * from member";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberBean bean = new MemberBean();
				bean.setId(rs.getInt("id"));
				bean.setRegdate(rs.getDate("regdate"));
				bean.setUpdatedate(rs.getDate("updatedate"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setLoginId(rs.getString("loginId"));
				bean.setLoginPw(rs.getString("loginPw"));
				bean.setAdminlevel(rs.getInt("adminlevel"));
				list.add(bean);
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
