package com.product.utility;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.product.entity.Product;

public class HibernateUtility {
	
	
	public static SessionFactory getSessionFactory() {
		
		Configuration configuration=new Configuration();
		configuration.configure().addAnnotatedClass(Product.class);
		SessionFactory factory=configuration.buildSessionFactory();
		
		return factory;
	}
	
	
	public static Product prepareProduct(Scanner scanner) {
		 
		Product product=new Product();
		
		System.out.print("enter product ID:-");
		product.setProductID(scanner.nextInt());
		System.out.print("enter productname:- ");
		product.setProductName(scanner.next());
		System.out.print("enter product price:-");
		product.setProductPrice(scanner.nextInt());
		System.out.print("enter product mfg date:-");
		product.setProductMfg(scanner.next());
		System.out.print("enter product category:-");
		product.setProductCatagory(scanner.next());
		
		return product;
	}

}
