package com.fms.services;

import com.fms.beans.Customer;
import com.fms.dao.CustomerDAO;
import com.fms.dao.CustomerJDBCImpl;

public class CustomerServicesImpl implements CustomerServices {
	CustomerDAO services = new CustomerJDBCImpl();

	@Override
	public Customer addCustomer(Customer customer) {
		return services.addCustomer(customer);
	}

	

	@Override
	public Customer modifyCustomer(Customer customer, String customerPassword) {
		return services.modifyCustomer(customer, customerPassword);
	}

	@Override
	public Customer searchCustomer(Integer customerId) {
		return services.searchCustomer(customerId);
	}



	@Override
	public boolean deleteCustomer(Integer customerId, String customerPassword) {
		return services.deleteCustomer(customerId, customerPassword);
	}
	
		
		
}
