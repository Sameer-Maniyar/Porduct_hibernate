package com.productRoot;

import java.util.Scanner;

import com.item.dao.ItemDao;
import com.product.entity.Product;
import com.product.service.ProductService;
import com.product.utility.HibernateUtility;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch;

		do {
			System.out.println("**************product************");
			System.out.println("press 1 to add product ");
			System.out.println("press 2 to get product by ID ");
			System.out.println("press 3 to delete product by ID ");
			System.out.println("press 4 to get add product ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("1");
				Product product = HibernateUtility.prepareProduct(scanner);
				ProductService productService = new ProductService();
				String msg = productService.saveProduct(product);
				System.out.println(msg);

				break;
			}

			case 2: {

				System.out.println("enter the productID ");
				int Id = scanner.nextInt();
				ProductService productService = new ProductService();
				Product product = productService.getProductById(Id);

				if (product != null) {
					System.out.println(product);
				} else {
					System.out.print("product not found:-");
				}

				break;
			}
			case 3: {
				
				 System.out.print("enter prodcut ID which you want to delete:-");
				 int productId=scanner.nextInt();
				 ProductService productService=new ProductService();
				 String message=productService.deleteProductById(productId);
				 
				 System.out.println(message);

				break;
			}
			default: {

				System.out.println("default");
				break;

			}

			}
			System.out.println("do you want to continue Y/N");
			ch = scanner.next().toLowerCase().charAt(0);

		} while (!(ch == 'n'));

	}

}
