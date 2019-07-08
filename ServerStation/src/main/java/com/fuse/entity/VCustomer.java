package com.fuse.entity;

public class VCustomer extends Customer {
	String meter_number;
	String order_id;

	public String getMeter_number() {
		return this.meter_number;
	}

	public void setMeter_number(String meter_number) {
		this.meter_number = meter_number;
	}

	public String getOrder_id() {
		return this.order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
}
