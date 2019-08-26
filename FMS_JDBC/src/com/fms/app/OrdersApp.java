package com.fms.app;

import java.util.Scanner;

import com.fms.beans.Orders;
import com.fms.exceptions.InvalidChoiceException;
import com.fms.exceptions.InvalidDataException;
import com.fms.exceptions.InvalidDateException;
import com.fms.exceptions.InvalidIdException;
import com.fms.services.OrdersServices;
import com.fms.services.OrdersServicesImpl;
import com.fms.services.Validation;

public class OrdersApp {
	public static void ordersApp() {

		Scanner scanner = new Scanner(System.in);
		OrdersServices services = new OrdersServicesImpl();
		Orders orders = null;
		do {
			System.out.println("1. AddOrders");
			System.out.println("2. ModifyOrders");
			System.out.println("3. DeleteOrders");
			System.out.println("4. Exit");
			System.out.println("Enter your choice");
			String ordersChoice = scanner.next();
			while(!Validation.isValidId(ordersChoice)) {
				try{
					throw new InvalidChoiceException();
				}catch(InvalidChoiceException e){
					System.out.println("Enter your choice :");
					ordersChoice = scanner.next();
				}
			}

			switch(Integer.parseInt(ordersChoice)) {


			case 1:
				orders = new Orders();
				System.out.println("Enter the Order Number :");
				String ordersNum = scanner.next();
				while(!Validation.isValidId(ordersNum)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Order Number :");
						ordersNum = scanner.next();
					}
				}
				orders.setOrderNo(Integer.parseInt(ordersNum));
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
				orders.setCustomerId(Integer.parseInt(customerId));
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
				orders.setProductId(Integer.parseInt(productId));
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
				orders.setHaulierId(Integer.parseInt(haulierId));
				System.out.println("Enter the Delivery date :");
				String deliveryDate = scanner.next();
				while(!Validation.isValidDate(deliveryDate)){
					try{
						throw new InvalidDateException();
					}catch(InvalidDateException e){
						System.out.println("Enter the Delivery date :");
						deliveryDate = scanner.next();
					}
				}
				orders.setDeliveryDate(deliveryDate);
				System.out.println("Enter the Quantity :");
				String qty = scanner.next();
				while(!Validation.isValidId(qty))
				{
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Quantity :");
						qty = scanner.next();
					}
				}
				Integer quantity = Integer.parseInt(qty);
				orders.setQuantity(quantity);
				Orders result = services.addOrders(orders);
				if(result != null)
					System.out.println(orders);
				else
					throw new InvalidDataException();
				break;
			case 2:
				orders = new Orders();
				System.out.println("Enter the Order Number :");
				ordersNum = scanner.next();
				while(!Validation.isValidId(ordersNum)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Order Number :");
						ordersNum = scanner.next();
					}
				}
				orders.setOrderNo(Integer.parseInt(ordersNum));
				System.out.println("Enter the Customer Id :");
				customerId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Customer Id :");
						customerId = scanner.next();
					}
				}
				orders.setCustomerId(Integer.parseInt(customerId));
				System.out.println("Enter the Product Id :");
				productId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Product Id :");
						productId = scanner.next();
					}

				}
				orders.setProductId(Integer.parseInt(productId));
				System.out.println("Enter the Haulier Id :");
				haulierId = scanner.next();
				while(!Validation.isValidId(customerId)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Haulier Id :");
						haulierId = scanner.next();
					}

				}
				orders.setHaulierId(Integer.parseInt(haulierId));
				System.out.println("Enter the Delivery date :");
				deliveryDate = scanner.next();
				while(!Validation.isValidDate(deliveryDate)){
					try{
						throw new InvalidDateException();
					}catch(InvalidDateException e){
						System.out.println("Enter the Delivery date :");
						deliveryDate = scanner.next();
					}
				}
				orders.setDeliveryDate(deliveryDate);
				orders.setDeliveryDate(deliveryDate);
				System.out.println("Enter the Quantity :");
				quantity = Integer.parseInt(scanner.next());
				orders.setQuantity(quantity);
				Orders result1 = services.modifyOrders(Integer.parseInt(ordersNum), orders);
				if(result1 != null)
					System.out.println(orders);
				else
					throw new InvalidDataException();
				break;
			case 3:
				orders = new Orders();
				orders = new Orders();
				System.out.println("Enter the Order Number :");
				ordersNum = scanner.next();
				while(!Validation.isValidId(ordersNum)) {
					try{
						throw new InvalidIdException();
					}catch(InvalidIdException e){
						System.out.println("Enter the Order Number :");
						ordersNum = scanner.next();
					}
				}
				Boolean ststus = services.deleteOrders(Integer.parseInt(ordersNum));
				if(ststus)
					System.out.println("Orders deleted");
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
