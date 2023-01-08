package com.item.dao;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.item.dao.*;
import com.product.entity.Product;
import com.product.utility.HibernateUtility;

public class ItemDao {

	private SessionFactory factory;
	boolean isSaved = false;

	public ItemDao() {

		factory = HibernateUtility.getSessionFactory();

	}

	public String saveProduct(Product product) {

		Session session = null;
		try {

			session = factory.openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();

			// verify if product already present in database
			Product ProductIfExist = session.get(Product.class, product.getProductID());

			if (ProductIfExist == null) {

				session.save(product);
				transaction.commit();
				isSaved = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("1");
		} finally {

			if (session != null) {
				session.close();
			}
		}

		if (isSaved) {
			return "product is sucessfully saved in data base";
		} else {
			return "something went worng product not saved!";
		}

	}

	public Product getProductById(int productId) {
		Session session = null;
		Product product = null;
		try {
			session = factory.openSession();
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}

		}

		return product;
	}

	public String deleteProductById(int productId) {
		Session session = null;
		String message = null;
		try {
			session = factory.openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();
			Product product = session.get(Product.class, productId);
			if (product != null) {
				session.delete(product);
				transaction.commit();
				message = "prduct data with ID " + productId + " deleted sucessfully";
			}else {
				
				message="something went worng could not delete product";
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}

		}
		return message;
	}

}
