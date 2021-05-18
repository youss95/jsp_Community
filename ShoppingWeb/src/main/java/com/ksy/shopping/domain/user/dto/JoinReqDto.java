package com.ksy.shopping.domain.user.dto;

import lombok.Data;

@Data
public class JoinReqDto {
private String user_id;
private String user_password;
private String user_email;
private String user_address;
}
