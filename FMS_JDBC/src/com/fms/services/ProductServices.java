package com.fms.services;

import com.fms.beans.Product;

public interface ProductServices {
	public Product addProduct(Product product);
	public boolean deleteProduct(Integer producttId);
	public Product modifyProduct(Integer contractId, Product product);
}
