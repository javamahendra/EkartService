package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.model.Item;
import com.app.model.Transaction;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveCustomer(Customer cust) {

		return (Integer) ht.save(cust);
	}

	@Override
	public void deleteCustomer(int custId) {

		ht.delete(new Customer(custId));

	}

	@Override
	public void updateCustomer(Customer cust) {
		ht.update(cust);

	}

	public Customer getCustomerById(int custId) {

		return ht.get(Customer.class, custId);
	}

	@Override
	public List<Customer> getAllCustomers() {

		return ht.loadAll(Customer.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getCustomerLocationsByCountWise() {

		String hql = " select loc.locName,count(loc.locName) from "
				+ Customer.class.getName() + " group by loc.locName ";
		return ht.find(hql);

	}

	@Override
	public boolean isEmailExist(String custEmail) {
		boolean flag = false;
		String hql = "from " + Customer.class.getName() + " where custEmail=?";
		@SuppressWarnings("unchecked")
		List<Customer> list = ht.find(hql, custEmail);
		if (list != null && list.size() > 0) {
			flag = true;
		}
		return flag;
	}

	// customer details by email
	public Customer getCustomerByEmail(String custEmail) {
		Customer cust = null;
		String hql = "from " + Customer.class.getName() + " where custEmail=?";
		@SuppressWarnings("unchecked")
		List<Customer> custListObj = ht.find(hql, custEmail);
		if (custListObj != null && custListObj.size() > 0) {
			cust = custListObj.get(0);
		}

		return cust;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getItemByCustId(int custId) {
		String hql = "from " + Item.class.getName() + " where custId=?";
		return ht.find(hql, custId);
	}
	@SuppressWarnings("unchecked")
	public List<Item> getTransactionByCustId(int custId) {
		String hql = "from " + Transaction.class.getName() + " where custId=?";
		return ht.find(hql, custId);
	}
}
