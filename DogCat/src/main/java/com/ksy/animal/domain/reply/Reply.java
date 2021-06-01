package com.ksy.animal.domain.reply;

import java.sql.Date;

import lombok.Data;
@Data
public class Reply {

	private int reply_no;
	private int user_no;
	private int blog_num;
	private String user_id;
	private String reply_content;
	private Date reply_createDate;
	
}
