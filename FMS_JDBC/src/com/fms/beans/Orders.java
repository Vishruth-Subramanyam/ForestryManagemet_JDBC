package com.fms.beans;

public class Orders {
	private Integer orderNo;
	private Integer customerId;
	private Integer productId;
	private Integer haulierId;
	private String deliveryDate;
	private Integer quantity;
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Orders [orderNo=" + orderNo + ", customerId=" + customerId + ", productId=" + productId + ", haulierId="
				+ haulierId + ", deliveryDate=" + deliveryDate + ", quantity=" + quantity + "]";
	}
}
