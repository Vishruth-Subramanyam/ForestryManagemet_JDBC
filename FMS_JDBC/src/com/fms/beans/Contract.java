package com.fms.beans;

public class Contract {
	private Integer contractNo;
	private Integer customerId;
	private Integer productId;
	private Integer haulierId;
	private String deliveryDate;
	private String deliveryDay;
	private Integer quantity;
	public Integer getContractNo() {
		return contractNo;
	}
	public void setContractNo(Integer contractNo) {
		this.contractNo = contractNo;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getHaulierId() {
		return haulierId;
	}
	public void setHaulierId(Integer haulierId) {
		this.haulierId = haulierId;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliveryDay() {
		return deliveryDay;
	}
	public void setDeliveryDay(String deliveryDay) {
		this.deliveryDay = deliveryDay;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Contract [contractNo=" + contractNo + ", customerId=" + customerId + ", productId=" + productId
				+ ", haulierId=" + haulierId + ", deliveryDate=" + deliveryDate + ", deliveryDay=" + deliveryDay
				+ ", quantity=" + quantity + "]";
	}


}
