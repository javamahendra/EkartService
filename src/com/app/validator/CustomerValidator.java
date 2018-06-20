package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CodecUtil;

@Component
public class CustomerValidator {
	@Autowired
	ICustomerService service;

	@Autowired
	private CodecUtil codecUtil;

	public boolean isEmailExist(String custEmail) {
		return service.isEmailExist(custEmail);
	}

	public boolean isIdExist(int custId) {
		boolean flag = false;
		Customer cust = service.getCustomerById(custId);
		if (cust != null) {
			flag = true;
		}
		return flag;
	}

	public Customer getCustomerbyEmail(String custEmail) {
		return service.getCustomerByEmail(custEmail);
	}

	/*
	 * this method will tell the pwd and access token is valid or not.
	 */
	public boolean isPwdTokenExist(String pwd, String token, Customer cust) {

		return pwd.equals(codecUtil.doDecode(cust.getPassword()))
				&& token.equals(codecUtil.doDecode(cust.getAccTock()));
	}

	/*
	 * this method will tell customer is Seller or not
	 */
	public boolean isCustomerSeller(Customer cust) {
		return "Seller".equals(cust.getCustType());
	}

	/*
	 * this method is used to customer is Consumer or not
	 */
	public boolean isCustomerConsumer(Customer cust) {
		return "Consumer".equals(cust.getCustType());
	}
}
