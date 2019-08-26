package com.fms.app;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.naming.InvalidNameException;

import com.fms.beans.Product;
import com.fms.exceptions.InvalidChoiceException;
import com.fms.exceptions.InvalidDataException;
import com.fms.exceptions.InvalidIdException;
import com.fms.services.ProductServices;
import com.fms.services.ProductServicesImpl;
import com.fms.services.Validation;

public class ProductApp { 

	public static void productApp() throws IOException {
		ProductServices services = new ProductServicesImpl();
		DataInputStream object = new DataInputStream(System.in);

		Product product = null;
		do {
			System.out.println("1. AddProduct");
			System.out.println("2. ModifyProduct");
			System.out.println("3. DeleteProduct");
			System.out.println("4. Exit");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your choice");
			String productChoice = scanner.next();
			while(!Validation.isValidId(productChoice)) {
				try{
					throw new InvalidChoiceException();
				}catch(InvalidChoiceException e){
					System.out.println("Enter your choice :");
					productChoice = scanner.next();
				}
			}

			switch(Integer.parseInt(productChoice)) {


			case 1:
				product = new Product();
				System.out.println("Enter the Product id :");
				String productId = scanner.next();
				while(!Validation.isValidId(productId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Product id :");
						productId = scanner.next();
					}
				}
				product.setProductId(Integer.parseInt(productId));
				System.out.println("Enter Product Name :");
				String  productName = object.readLine();
				while(!Validation.isValidName(productName)) {
					try{
						throw new InvalidNameException();
					}catch(InvalidNameException e){
						System.out.println("Enter Product Name :");
						productName = object.readLine();

					}
				}
				product.setProductName(productName);

				System.out.println("Enter the Product Description :");
				String productDescription = object.readLine();
				product.setProductDescription(productDescription);
				Product result = services.addProduct(product);
				if(result != null)
					System.out.println(product);
				else
					throw new InvalidDataException();
				break;
			case 2:
				product = new Product();
				int productID = 0;
				System.out.println("Enter the Product id :");
				productId = scanner.next();
				while(!Validation.isValidId(productId)) {
					try{
						throw new InvalidIdException();

					}catch(InvalidIdException e){
						System.out.println("Enter the Product id :");
						productId = scanner.next();
					}
				}
				productID = Integer.parseInt(productId);
				System.out.println("Enter the Product Name :");
				productName = object.readLine();
				while(!Validation.isValidName(productName)){
					try{
						throw new InvalidNameException();
					}catch(InvalidNameException e){
						System.out.println("Enter the Product Name :");
						productName = object.readLine();
					}
				}
				product.setProductName(productName);
				System.out.println("Enter the Product Description :");
				object = new DataInputStream(System.in);
				productDescription = object.readLine();
				product.setProductDescription(productDescription);
				result = services.modifyProduct(productID, product);
				product.setProductId(Integer.parseInt(productId));
				if(result != null) 
					System.out.println(product);
				else
					throw new InvalidDataException();
				break;
			case 3:
				product = new Product();
				productID = 0;
				System.out.println("Enter the Product id :");
				productId = scanner.next();
				while(!Validation.isValidId(productId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Product id :");
						productId = scanner.next();
					}

				}
				productID = Integer.parseInt(productId);
				Boolean result1 = services.deleteProduct(productID);
				if(result1)
					System.out.println("Product details deleted");
				else
					throw new InvalidDataException();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Enter the correct choice");

				break;
			}
		}while(true);
	}
}