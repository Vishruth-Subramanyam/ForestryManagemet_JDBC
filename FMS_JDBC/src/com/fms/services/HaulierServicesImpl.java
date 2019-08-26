package com.fms.services;

import com.fms.beans.Haulier;
import com.fms.dao.HaulierDAO;
import com.fms.dao.HaulierJDBCImpl;

public class HaulierServicesImpl implements HaulierServices{
	HaulierDAO db = new HaulierJDBCImpl();
	@Override
	public Haulier addHaulier(Haulier haulier) {
		return db.addHaulier(haulier);
	}
	
	@Override
	public boolean deleteHaulier(Integer haulierId, String haulierPassword) {
		return db.deleteHaulier(haulierId, haulierPassword);
	}
	@Override
	public Haulier searchHaulier(Integer haulierId) {
		return db.searchHaulier(haulierId);
	}

	@Override
	public Haulier modifyHaulier(Haulier haulier, String passwd) {
		// TODO Auto-generated method stub
		return db.modifyHaulier(haulier, passwd);
	}

}
