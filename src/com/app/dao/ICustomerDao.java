package com.app.dao;

import java.util.List;

import com.app.model.Customer;
import com.app.model.Item;

public interface ICustomerDao {
	
public int saveCustomer(Customer cust);
public void deleteCustomer(int custId);
public void updateCustomer(Customer cust);
public Customer getCustomerById(int custId);
public List<Customer> getAllCustomers();
public List<Object[]> getCustomerLocationsByCountWise();
public boolean isEmailExist(String custEmail);
public Customer getCustomerByEmail(String custEmail);
public List<Item> getItemByCustId(int custId);
public List<Item> getTransactionByCustId(int custId);
}
