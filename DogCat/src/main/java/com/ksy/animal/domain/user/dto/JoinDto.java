package com.ksy.animal.domain.user.dto;

import lombok.Data;

@Data
public class JoinDto {
	private String user_id;
	private String user_password;
	private String user_email;
	private String user_address;
}
