package com.ksy.animal.domain.blog.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class WriteDto {

	private int user_no;
private String bTitle;
private String bContent;
private String bfileName;
private String bfileRealName;
private Date createdate;	
}
