package com.fms.services;

import com.fms.beans.Contract;
import com.fms.dao.ContractDAO;
import com.fms.dao.ContractJDBCImpl;

public class ContractServicesImpl implements ContractServices {
	ContractDAO services = new ContractJDBCImpl();

	@Override
	public Contract addContract(Contract contract) {
		return services.addContractor(contract);
	}

	@Override
	public boolean deleteContract(Integer contractId) {
		return services.deleteContractor(contractId);
	}

	@Override
	public Contract modifyCustomer(Integer contractId, Contract contract) {
		return services.modifyContractor(contractId, contract);
	}

	
}
