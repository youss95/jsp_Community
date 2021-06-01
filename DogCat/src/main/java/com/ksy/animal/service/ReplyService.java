package com.ksy.animal.service;

import com.ksy.animal.domain.reply.ReplyDao;

public class ReplyService {

	ReplyDao replyDao;
	public ReplyService() {
		replyDao = new ReplyDao();
	}

	public int 댓글달기(String user_id, int user_no , int blognum,String reply_content) {
		
		return replyDao.insertReply(user_id,user_no,blognum,reply_content);
	}
	
	
}
