package com.saspect.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.saspect.customer.bo.CustomerBo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");
        CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
    	//customer.addCustomer();
        customer.addCustomerReturnValue();
        
        try {
			//customer.addCustomerThrowException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        customer.addCustomerAround("Sercan ÇELENK");
    }
}
