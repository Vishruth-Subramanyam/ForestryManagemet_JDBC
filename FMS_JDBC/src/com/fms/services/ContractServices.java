package com.fms.services;

import com.fms.beans.Contract;

public interface ContractServices {
	public Contract addContract(Contract contract);
	public boolean deleteContract(Integer contractId);
	public Contract modifyCustomer(Integer contractId, Contract contract);
}
