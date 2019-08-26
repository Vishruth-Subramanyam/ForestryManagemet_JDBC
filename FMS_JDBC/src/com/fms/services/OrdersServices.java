package com.fms.services;

import com.fms.beans.Orders;

public interface OrdersServices {
	public Orders addOrders(Orders order);
	public Orders modifyOrders(Integer ordersNum, Orders orders);
	public boolean deleteOrders(Integer ordersNum);
}
