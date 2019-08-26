package com.fms.app;

import java.util.Scanner;

import com.fms.beans.Contract;
import com.fms.dao.ContractJDBCImpl;
import com.fms.exceptions.InvalidChoiceException;
import com.fms.exceptions.InvalidDataException;
import com.fms.exceptions.InvalidDateException;
import com.fms.exceptions.InvalidDayException;
import com.fms.exceptions.InvalidIdException;
import com.fms.services.ContractServices;
import com.fms.services.ContractServicesImpl;
import com.fms.services.Validation;

public class ContractApp {
	public static void contractApp() {
		ContractServices services = new ContractServicesImpl();
		Scanner scanner = new Scanner(System.in);
		Contract contract = null;
		do {
			System.out.println("1. AddContractor");
			System.out.println("2. DeleteContractor");
			System.out.println("3. ModifyContract");
			System.out.println("4. Exit");
			System.out.println("Enter your choice");
			String contractChoice = scanner.next();
			while(!Validation.isValidId(contractChoice)) {
				try{
					throw new InvalidChoiceException();
				}catch(InvalidChoiceException e){
					System.out.println("Enter your choice :");
					contractChoice = scanner.next();
				}
			}
			switch(Integer.parseInt(contractChoice) ){
			case 1:  
				contract = new Contract();
				System.out.println("Enter the Contractor Number :");
				String contractNumber = scanner.next();
				while(!Validation.isValidId(contractNumber)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Contractor Number :");
						contractNumber = scanner.next();
					}
				}
					contract.setContractNo(Integer.parseInt(contractNumber));
				System.out.println("Enter the Customer Id :");
				String customerId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Customer Id :");
						customerId = scanner.next();
					}
				}
				contract.setCustomerId(Integer.parseInt(customerId));
				System.out.println("Enter the Product Id :");
				String productId = scanner.next();
				while(!Validation.isValidId(productId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Product Id :");
						productId = scanner.next();
					}
				}
					contract.setProductId(Integer.parseInt(productId));
				
				System.out.println("Enter the Haulier Id :");
				String haulierId = scanner.next();
				while(!Validation.isValidId(haulierId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Haulier Id :");
						haulierId = scanner.next();
					}
				}
				contract.setHaulierId(Integer.parseInt(haulierId));
				System.out.println("Enter the Delivery date :");
				String deliveryDate = scanner.next();
				while(!Validation.isValidDate(deliveryDate)) {
					try{
						throw new InvalidDateException();
					}catch(InvalidDateException i){
						System.out.println("Enter the Delivery Date :");
						deliveryDate = scanner.next();
					}
				}
					contract.setDeliveryDate(deliveryDate);
				System.out.println("Enter the Delivery day :");
				String deliveryDay = scanner.next();
				while(!Validation.isValidDay(deliveryDay)) {
					try{
						throw new InvalidDayException();
					}catch(InvalidDayException i){
						System.out.println("Enter the Delivery Day :");
						deliveryDay = scanner.next();
					}
				}
					contract.setDeliveryDay(deliveryDay);
				System.out.println("Enter the Quantity :");
				Integer quantity = Integer.parseInt(scanner.next());
				contract.setQuantity(quantity);
				Contract result = services.addContract(contract);
				if(result!=null)
					System.out.println(contract);
				else
					throw new InvalidDataException();
				break;
			case 2:
				contract = new Contract();
				System.out.println("Enter the Contractor Number :");
				contractNumber = scanner.next();
				while(!Validation.isValidId(contractNumber)) {
					try {
						throw new InvalidIdException();
					} catch (InvalidIdException e) {
						System.out.println("Enter the Contractor Number :");
						contractNumber = scanner.next();
						e.printStackTrace();
					}
				}
					contract.setContractNo(Integer.parseInt(contractNumber));

				boolean result1 = services.deleteContract(Integer.parseInt(contractNumber));
				if(result1)
					System.out.println("Contract deleted");
				else
					throw new InvalidDataException();
				break;
			case 3:
				contract = new Contract();
				System.out.println("Enter the Contractor Number :");
				contractNumber = scanner.next();
				while(!Validation.isValidId(contractNumber)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Contractor Number :");
						contractNumber = scanner.next();
					}
				}
					contract.setContractNo(Integer.parseInt(contractNumber));
				System.out.println("Enter the Delivery date :");
				deliveryDate = scanner.next();
				while(!Validation.isValidDate(deliveryDate)) {
					try{
						throw new InvalidDateException();
					}catch(InvalidDateException i){
						System.out.println("Enter the Delivery Date :");
						deliveryDate = scanner.next();
					}
				}
					contract.setDeliveryDate(deliveryDate);
				System.out.println("Enter the Delivery day :");
				deliveryDay = scanner.next();
				while(!Validation.isValidDay(deliveryDay)) {
					try{
						throw new InvalidDayException();
					}catch(InvalidDayException i){
						System.out.println("Enter the Delivery Day :");
						deliveryDay = scanner.next();
					}
				}
				contract.setDeliveryDay(deliveryDay);
				System.out.println("Enter the Quantity :");
				quantity = Integer.parseInt(scanner.next());
				String qty = Integer.toString(quantity);
				while(!Validation.isValidId(qty)){
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Quantity :");
						quantity = Integer.parseInt(scanner.next());
					}
				}
				quantity = Integer.parseInt(qty);
				contract.setQuantity(quantity);
				Integer contractNumbr = Integer.parseInt(contractNumber);
				result = services.modifyCustomer(contractNumbr, contract);
				if(result!=null)
					System.out.println(contract);
				else
					throw new InvalidDataException();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Enter Valid Choice");
				break;
			}
		}while(true);
	}

}
