package com.fms.services;

import com.fms.beans.Haulier;

public interface HaulierServices {
	public Haulier addHaulier(Haulier haulier);
	public boolean deleteHaulier(Integer haulierId,String haulierPassword);
	public Haulier searchHaulier(Integer haulierId);
	public Haulier modifyHaulier(Haulier haulier,String passwd);


}
