package com.ksy.animal.domain.blog;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog {

	private int bNo;
	private int user_no;
	private String bTitle;
	private String bContent;
	private String bfileName;
	private String bfileRealName;
	private int bHit;
	private Date bCreateDate;
}
