package com.fms.beans;

public class Haulier {
	private Integer haulierId;
	private String haulierName;
	private Long telephoneNumber;
	private String emailAddress;
	private Address address;
	private String haulierPassword;
	public Integer getHaulierId() {
		return haulierId;
	}
	public void setHaulierId(Integer haulierId) {
		this.haulierId = haulierId;
	}
	public String getHaulierName() {
		return haulierName;
	}
	public void setHaulierName(String haulierName) {
		this.haulierName = haulierName;
	}
	public Long getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(Long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getHaulierPassword() {
		return haulierPassword;
	}
	public void setHaulierPassword(String haulierPassword) {
		this.haulierPassword = haulierPassword;
	}
	@Override
	public String toString() {
		return "Haulier [haulierId=" + haulierId + ", haulierName=" + haulierName + ", telephoneNumber="
				+ telephoneNumber + ", emailAddress=" + emailAddress + ", address=" + address + ", haulierPassword="
				+ haulierPassword + "]";
	}

}
