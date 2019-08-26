package com.fms.dao;

import com.fms.beans.Orders;

public interface OrdersDAO {
	public Orders addOrders(Orders order);
	public Orders modifyOrders(Integer ordersNum, Orders orders);
	public boolean deleteOrders(Integer ordersNum);
}
