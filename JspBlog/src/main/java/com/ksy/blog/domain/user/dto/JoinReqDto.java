package com.ksy.blog.domain.user.dto;

import java.sql.Date;

import com.ksy.blog.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class JoinReqDto {
private String username;
private String password;
private String emai;
private String address;

}
