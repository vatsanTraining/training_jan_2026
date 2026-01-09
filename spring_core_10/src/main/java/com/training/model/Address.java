package com.training.model;

public class Address {

	
	private String addressLineOne;
	private String city;
	private long pincode;
	
	
	public Address() {
		super();
	}
	public Address(String addressLineOne, String city, long pincode) {
		super();
		this.addressLineOne = addressLineOne;
		this.city = city;
		this.pincode = pincode;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressLineOne=" + addressLineOne + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
}
