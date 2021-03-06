package com.ksy.blog.domain.board;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
private int id;
private int userId;
private String title;
private String content;
private int readCount; //์กฐํ์
private Date createDate;
	
public String getTitle() {
	return title.replaceAll("<","&lt;").replaceAll(">","&gt;");
}



}
