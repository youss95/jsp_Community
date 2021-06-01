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

	private int blognum;
	private int user_no;
	private String title;
	private String content;
	private String bfileName;
	private String bfileRealName;
	private int hit;
	private Date createdate;
}
