package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerDao dao;
	public int saveCustomer(Customer cust) {
		
		return dao.saveCustomer(cust);
	}

	@Override
	public void deleteCustomer(int custId) {
		dao.deleteCustomer(custId);
		
	}

	@Override
	public void updateCustomer(Customer cust) {
		dao.updateCustomer(cust);
		
	}

	@Override
	public Customer getCustomerById(int custId) {
		
		return dao.getCustomerById(custId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return dao.getAllCustomers();
	}
@Override
public List<Object[]> getCustomerLocationsByCountWise() {
	
	return dao.getCustomerLocationsByCountWise();
	
}
@Override
public boolean isEmailExist(String custEmail) {
	
	return dao.isEmailExist(custEmail);
}@Override
public Customer getCustomerByEmail(String custEmail) {

	return dao.getCustomerByEmail(custEmail);
}
@Override
public List<Item> getItemByCustId(int custId) {
	
	return dao.getItemByCustId(custId);
}
public List<Item> getTransactionByCustId(int custId) {
	
	return dao.getTransactionByCustId(custId);
}
}
