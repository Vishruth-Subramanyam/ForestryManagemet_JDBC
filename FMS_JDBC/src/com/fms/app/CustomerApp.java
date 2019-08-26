package com.fms.app;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.fms.beans.Address;
import com.fms.beans.Customer;
import com.fms.exceptions.InvalidChoiceException;
import com.fms.exceptions.InvalidDataException;
import com.fms.exceptions.InvalidEmailException;
import com.fms.exceptions.InvalidIdException;
import com.fms.exceptions.InvalidNameException;
import com.fms.exceptions.InvalidPasswordException;
import com.fms.exceptions.InvalidPostCodeException;
import com.fms.exceptions.InvalidTelNoException;
import com.fms.exceptions.InvalidTownCityException;
import com.fms.services.CustomerServices;
import com.fms.services.CustomerServicesImpl;
import com.fms.services.Validation;

public class CustomerApp {

	public static void customerApp() throws IOException {
		DataInputStream object = new DataInputStream(System.in);

		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Create Customer");
			System.out.println("2. Modify Customer");
			System.out.println("3. Search Customer");
			System.out.println("4. Delete Customer");
			System.out.println("5. Exit");
			System.out.println("Enter choice");
			String custChoice =scanner.next();
			CustomerServices db = new CustomerServicesImpl();
			Customer customer = null;
			Address address =  new Address();
			while(!Validation.isValidId(custChoice)) {
				try{
					throw new InvalidChoiceException();
				}catch(InvalidChoiceException e){
					System.out.println("Enter your choice :");
					custChoice = scanner.next();
				}
			}

			switch(Integer.parseInt(custChoice)) {
			case 1: 
				customer = new Customer();
				System.out.println("Enter Customer id :");
				String customerId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException i){
						System.out.println("Enter Customer id :");
						customerId = scanner.next();
					}
				}
				customer.setCustomerId(Integer.parseInt(customerId));
				System.out.println("Enter customer Name :");
				String  customerName = object.readLine();
				while(!Validation.isValidName(customerName)) {
					try{
						throw new InvalidNameException();
					}catch(InvalidNameException i){
						System.out.println("Enter Customer Name :");
						customerName = object.readLine();
					}
				}
				customer.setCustomerName(customerName);
				System.out.println("Enter Street Address 1 :");
				String streetAddress1=scanner.next();
				address.setStreetAddress1(streetAddress1);
				System.out.println("Enter the Streeet Address 2 :");
				String streetAddress2=scanner.next();
				address.setStreetAddress2(streetAddress2);
				System.out.println("Enter the Town City :");
				String townCity=scanner.next();
				while(!Validation.isValidtownCity(townCity)) {
					try{
						throw new InvalidTownCityException();
					}catch(InvalidTownCityException e){
						System.out.println("Enter the town city :");
						townCity=scanner.next();
					}
				}
				address.setTownCity(townCity);
				System.out.println("Enter Post Code :");
				String postCode=scanner.next();
				customer.setAddress(address);
				while(!Validation.isValidPostCode(postCode)) {
					try{
						throw new InvalidPostCodeException();
					}catch(InvalidPostCodeException i){
						System.out.println("Enter Post Code :");
						postCode = scanner.next();
					}
				}
				address.setPostCode(Integer.parseInt(postCode));
				System.out.println("Enter Telephone number :");
				String telephoneNumber = scanner.next();
				while(!Validation.isValidTelNum(telephoneNumber)) {
					try{
						throw new InvalidTelNoException();
					}catch(InvalidTelNoException i){
						System.out.println("Enter Telephone number :");
						telephoneNumber = scanner.next();
					}
				}
				customer.setTelephoneNumber(Long.parseLong(telephoneNumber));
				System.out.println("Enter the Email :");
				String email=scanner.next();
				while(!Validation.isEmailValid(email)) {
					try{
						throw new InvalidEmailException();
					}catch(InvalidEmailException e){
						System.out.println("Enter the Email :");
						email=scanner.next();
					}
				}
				customer.setEmailAddress(email);
				System.out.println("Enter Customer password :");
				String password = scanner.next();
				while(!Validation.isValidPassword(password)) {
					try{
						throw new InvalidPasswordException();
					}catch(InvalidPasswordException e)
					{
						System.out.println("Enter Customer password :");
						password = scanner.next();
					}
				}
				customer.setCustomerPassword(password);
				Customer result = db.addCustomer(customer);

				if(result!=null){
					System.out.println(result);
				}
				else{
					throw new InvalidDataException();
				}
				break;
			case 2: 
				customer = new Customer(); 
				System.out.println("Enter Customer id :");
				String customerId1 = scanner.next();
				while(!Validation.isValidId(customerId1)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException i){
						System.out.println("Enter Customer id :");
						customerId1 = scanner.next();
					}
				}
				customer.setCustomerId(Integer.parseInt(customerId1));
				System.out.println("Enter Customer password :");
				 password = scanner.next();
				while(!Validation.isValidPassword(password)) {
					try{
						throw new InvalidPasswordException();
					}catch(InvalidPasswordException e)
					{
						System.out.println("Enter Customer password :");
						password = scanner.next();
					}
				}				
				System.out.println("Enter customer Name :");
				String customerName1 = object.readLine();
				while(!Validation.isValidName(customerName1)) {
					try{
						throw new InvalidNameException();
					}catch(InvalidNameException i){
						System.out.println("Enter Customer Name :");
						customerName1 = object.readLine();
					}
				}
				customer.setCustomerName(customerName1);
				System.out.println("Enter Street Address 1 :");
				String streetAddress11=scanner.next();
				address.setStreetAddress1(streetAddress11);
				System.out.println("Enter the Streeet Address 2 :");
				String streetAddress21=scanner.next();
				address.setStreetAddress2(streetAddress21);
				System.out.println("Enter the Town City :");
				String townCity1=scanner.next();
				address.setTownCity(townCity1);
				System.out.println("Enter Post Code :");
				String postCode1=scanner.next();
				while(!Validation.isValidPostCode(postCode1)) {
					try{
						throw new InvalidPostCodeException();
					}catch(InvalidPostCodeException i){
						System.out.println("Enter Post Code :");
						postCode1 = scanner.next();
					}
				}
				address.setPostCode(Integer.parseInt(postCode1));
				customer.setAddress(address);
				System.out.println("Enter Telephone number :");
				telephoneNumber = scanner.next();
				while(!Validation.isValidTelNum(telephoneNumber)) {
					try{
						throw new InvalidTelNoException();
					}catch(InvalidTelNoException i){
						System.out.println("Enter Telephone number :");
						telephoneNumber = scanner.next();
					}


				}
				customer.setTelephoneNumber(Long.parseLong(telephoneNumber));
				System.out.println("Enter the Email :");
				String email1=scanner.next();
				while(! Validation.isEmailValid(email1)) {
					try{
						throw new InvalidEmailException();
					}catch(InvalidEmailException e){
						System.out.println("Enter the Email :");
						email1=scanner.next();
					}
				}
				customer.setEmailAddress(email1);
				System.out.println("Enter Customer password :");
				String password1 = scanner.next();
				while(!Validation.isValidPassword(password1)) {
					try{
						throw new InvalidPasswordException();
					}catch(InvalidPasswordException e)
					{
						System.out.println("Enter Customer password :");
						password1 = scanner.next();
					}
				}
				customer.setCustomerPassword(password1);
				result = db.modifyCustomer(customer, password);
				if(result!=null)
					System.out.println(customer);
				else
					throw new InvalidDataException();
				break;
			case 3: 
				customer = new Customer();
				System.out.println("Enter Customer id :");
				customerId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException i){
						System.out.println("Enter Customer id :");
						customerId = scanner.next();
					}
				}
				customer = db.searchCustomer(Integer.parseInt(customerId));
				if(customer != null) {
					System.out.println(customer);
				}else{
					while(customer == null){
						try{
							throw new InvalidDataException();
						}catch(InvalidDataException i){
							customerId = scanner.next();
							while(!Validation.isValidId(customerId)) {
								try{
									throw new InvalidIdException();
								}catch(InvalidIdException x){
									System.out.println("Enter Customer id :");
									customerId = scanner.next();
								}
							}
							customer = db.searchCustomer(Integer.parseInt(customerId));
						}
					}
				}
				break;
			case 4: 
				customer = new Customer();
				System.out.println("Enter Customer id :");
				customerId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException i){
						System.out.println("Enter Customer id :");
						customerId = scanner.next();
					}
				}

				System.out.println("Enter Customer password :");
				password = scanner.next();
				while(!Validation.isValidPassword(password)) {
					try{
						throw new InvalidPasswordException();
					}catch(InvalidPasswordException e)
					{
						System.out.println("Enter Customer password :");
						password = scanner.next();
					}
				}
				Boolean state = db.deleteCustomer(Integer.parseInt(customerId), password);
				while (!state)
				{
					try{
						throw new InvalidDataException();
					}catch(InvalidDataException i){
						System.out.println("Enter Customer id :");
						customerId = scanner.next();
						while(!Validation.isValidId(customerId)) {
							try{
								throw new InvalidIdException();
							}catch(InvalidIdException f){
								System.out.println("Enter Customer id :");
								customerId = scanner.next();
							}
						}

						System.out.println("Enter Customer password :");
						password = scanner.next();
						while(!Validation.isValidPassword(password)) {
							try{
								throw new InvalidPasswordException();
							}catch(InvalidPasswordException e)
							{
								System.out.println("Enter Customer password :");
								password = scanner.next();
							}
						}
						state = db.deleteCustomer(Integer.parseInt(customerId), password);

					}
				}
				System.out.println("Profile Deleted");
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Enter the correct choice");
				break;
			}
		}while(true);

	}

}

