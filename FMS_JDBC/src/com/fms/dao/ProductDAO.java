package com.fms.dao;

import com.fms.beans.Product;

public interface ProductDAO {
	public Product addProduct(Product product);
	public boolean deleteProduct(Integer productId);
	public Product modifyProduct(Product product, Integer productId);
}
