package com.saspect.customer.bo;

public interface CustomerBo {
	void addCustomer();
	 
	String addCustomerReturnValue();
 
	void addCustomerThrowException() throws Exception;
 
	void addCustomerAround(String name);
}
