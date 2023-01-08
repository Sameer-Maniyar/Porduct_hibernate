package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @Column(name="id")
	private int productId;
    
    @Column(nullable = false)
	private String productName;
    
    @Column(nullable = false)
    
	private int productPrice;
	private String productMfg;
	
	 @Column(nullable = false)
	private String productCatagory;

	public Product() {
		super();

	}

	public Product(int priductID, String productName, int productPrice, String productMfg, String productCatagory) {
		super();
		this.productId = priductID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productMfg = productMfg;
		this.productCatagory = productCatagory;
	}

	public int getProductID() {
		return productId;
	}

	public void setProductID(int priductID) {
		this.productId = priductID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductMfg() {
		return productMfg;
	}

	public void setProductMfg(String productMfg) {
		this.productMfg = productMfg;
	}

	public String getProductCatagory() {
		return productCatagory;
	}

	public void setProductCatagory(String productCatagory) {
		this.productCatagory = productCatagory;
	}

	@Override
	public String toString() {
		return "Product [priductID=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productMfg=" + productMfg + ", productCatagory=" + productCatagory + "]";
	}
	
	

}
