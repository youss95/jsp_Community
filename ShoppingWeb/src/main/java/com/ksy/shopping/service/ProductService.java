package com.ksy.shopping.service;

import java.util.List;

import com.ksy.shopping.domain.product.Product;
import com.ksy.shopping.domain.product.ProductDao;
import com.ksy.shopping.domain.product.dto.DetailReqDto;
import com.ksy.shopping.domain.product.dto.UploadReqDto;

public class ProductService {

	
	ProductDao productDao;
	public ProductService() {
		productDao = new ProductDao();
	}
	
	public int 업로드(UploadReqDto dto) {
		
		return productDao.upload(dto);
	}
	
	public List<Product> 상품목록보기(){
		
		
	 return productDao.showList();
	}
	
	public DetailReqDto 상세상품(int product_no) {
		
		return productDao.getDetail(product_no);
		
	}
	
}
