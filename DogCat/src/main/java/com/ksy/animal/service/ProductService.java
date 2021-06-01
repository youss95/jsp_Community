package com.ksy.animal.service;

import java.util.List;

import com.ksy.animal.domain.product.Product;
import com.ksy.animal.domain.product.ProductDao;
import com.ksy.animal.domain.product.dto.CartInsertDto;
import com.ksy.animal.domain.product.dto.UploadDto;

public class ProductService {

	
	
	ProductDao productDao;
	public ProductService() {
		productDao = new ProductDao();
	}
	
	
	public List<Product> 상품목록(){
		
		return productDao.showProductList();
	}
	
	public int 업로드(UploadDto dto) {
		
		return productDao.uploadProduct(dto);
	}
	
	public Product  상품상세보기(int pNo) {
		
		return productDao.showDetail(pNo);
	}
	
	public int 장바구니(CartInsertDto dto) {
		
		return productDao.insertCart(dto);
	}
}
