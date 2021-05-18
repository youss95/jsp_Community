package com.ksy.shopping.domain.user;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
private int user_no;
private String user_id;
private String user_password;
private String user_email;
private String user_address;
private String userRole;
private Date createDate;
	
	//회원가입 할 때 필요한 필드 no,id,password,email,address
}
