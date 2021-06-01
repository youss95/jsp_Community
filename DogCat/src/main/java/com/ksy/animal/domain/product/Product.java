package com.ksy.animal.domain.product;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
private int productnumber;
private String pCategory;
private int pStock;
private String name;
private String color;
private String size;
private String pDetail;
private int price;
private Date pCreateDate;
private int pHit;
private String pfileName;
private String fileRealName;
	
	
}
