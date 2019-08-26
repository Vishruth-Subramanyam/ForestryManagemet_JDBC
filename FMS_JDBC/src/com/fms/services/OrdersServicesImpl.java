package com.fms.services;

import com.fms.beans.Orders;
import com.fms.dao.OrdersDAO;
import com.fms.dao.OrdersJDBCImpl;

public class OrdersServicesImpl implements OrdersServices {
	OrdersDAO db = new OrdersJDBCImpl();

	@Override
	public Orders addOrders(Orders order) {
		return db.addOrders(order);
	}

	@Override
	public Orders modifyOrders(Integer ordersNum, Orders order) {
		return db.modifyOrders(ordersNum, order);
	}

	@Override
	public boolean deleteOrders(Integer ordersNum) {
		return db.deleteOrders(ordersNum);
	}

	
	

	
}
