package com.ksy.animal.domain.reply.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyDto {

	private int reply_no;
	private int user_no;
	private String reply_content;
	private Date reply_createDate;
	private String user_id;
}
