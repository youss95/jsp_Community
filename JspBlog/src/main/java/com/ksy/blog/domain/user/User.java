package com.ksy.blog.domain.user;

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

	private int id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String userRole;
	private Date createDate;
}
