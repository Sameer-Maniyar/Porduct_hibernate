package com.product.service;

import com.item.dao.ItemDao;
import com.product.entity.Product;

public class ProductService {
	private ItemDao dao = new ItemDao();

	public String saveProduct(Product product) {

		/*
		 * audit product fields before feeding to databases product price can not be
		 * negative product category must be full fill
		 */

		if (product.getProductPrice() > 0 && !(product.getProductCatagory() == null)) {
			String status = dao.saveProduct(product);
			return status;
		} else {
			return "check product price or check if category updated correctly";
		}

	}

	public Product getProductById(int productId) {

		Product product = dao.getProductById(productId);

		return product;
	}

	public String deleteProductById(int productId) {
		
		String message=dao.deleteProductById(productId);

		return message;

	}

}
