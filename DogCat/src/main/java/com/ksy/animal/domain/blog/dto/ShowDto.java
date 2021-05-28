package com.ksy.animal.domain.blog.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowDto {

	private String user_id;
	private String title;
	private String fileRealName;
	private String fileName;
private Date CreateDate;
}
