package com.fms.dao;

import com.fms.beans.Contract;

public interface ContractDAO {
	public Contract addContractor(Contract cont);
	public boolean deleteContractor(Integer contractId);
	public Contract modifyContractor(Integer contractId, Contract contract);
	
}
