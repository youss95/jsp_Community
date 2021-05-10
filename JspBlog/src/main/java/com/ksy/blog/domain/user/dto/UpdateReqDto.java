package com.ksy.blog.domain.user.dto;

import lombok.Data;

@Data
public class UpdateReqDto {
private String password;
private String email;
private String address;

}
