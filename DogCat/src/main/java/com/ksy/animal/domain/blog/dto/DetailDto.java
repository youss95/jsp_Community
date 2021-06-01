package com.ksy.animal.domain.blog.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class DetailDto {

	private int blognum;
	private int user_no;
	private String title;
	private String content;
	private String fileRealName;
	private int hit;
	private Date createDate;
	
}
