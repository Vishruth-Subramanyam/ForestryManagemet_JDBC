package com.fms.dao;

import com.fms.beans.Haulier;

public interface HaulierDAO {
	public Haulier addHaulier(Haulier haulier);
	public boolean deleteHaulier(Integer haulierId,String haulierPassword);
	public Haulier searchHaulier(Integer haulierId);
	public Haulier modifyHaulier(Haulier haulier,String passwd);

}
	