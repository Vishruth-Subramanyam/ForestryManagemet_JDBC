package com.fms.services;

import com.fms.beans.Customer;

public interface CustomerServices {
	public Customer addCustomer(Customer customer);
	public boolean deleteCustomer(Integer customerId, String customerPassword);
	public Customer modifyCustomer(Customer customer ,String customerPassword);
	public Customer searchCustomer(Integer customerId);
}
