package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.impl.ItemServiceImpl;
import com.app.util.CodecUtil;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;
import com.app.validator.ItemValidator;

/**
 * @author krishnareddy
 * 
 */
@Path("/home")
@Component
public class ItemServiceProvider {
	@Autowired
	private ItemServiceImpl service;
	@Autowired
	CustomerValidator customerValidator;
	@Autowired
	CodecUtil codecUtil;
	@Autowired
	JsonUtil jsonUtil;
	@Autowired
	private ItemValidator itemValidator;

	@Path("/item")
	@POST
	/**
	 * this method is take the userName,password
	 * token and json and authenticate if it is valid item is stored in database
	 * @param un
	 * @param pwd
	 * @param token
	 * @param jsonItem
	 * @return
	 */
	public String saveItem(@HeaderParam("userName") String un,
			@HeaderParam("Password") String pwd,
			@HeaderParam("accesToken") String token, String jsonItem) {
		// user name is null or not
		if (un == null || "".equals(un.trim())) {
			return "Customer can not be empty/null";

		}
		// pwd is null or not
		else if (pwd == null) {
			return "password can't be empty/null";
		} else if (token == null || "".equals(token.trim())) {
			return "accees token can't be empty/null";
		}
		// jsonItem is null or not
		else if (jsonItem == null || "".equals(jsonItem.trim())) {
			return "item can't be empty/null";
		}

		// getting customer by customerEmail
		Customer cust = customerValidator.getCustomerbyEmail(un);
		// authentication of userName mail
		if (cust == null) {
			return "Invalid Customer(customerNotExist)";
		}

		/*
		 * accesToken and pwd authentication
		 */
 
		if (!customerValidator.isPwdTokenExist(pwd, token, cust)) {
			return "invalid credentials";
		}
		// customer type authentication
		
		if (!customerValidator.isCustomerSeller(cust)) {
			return "customer  not a Seller";
		}

		// converting json to item object
		Object ob = jsonUtil.JsonToObject(jsonItem, Customer.class);
		if (ob == null) {
			return "invalid json format";
		}
		// downcasting
		Item item = (Item) ob;
		if (itemValidator.isIdExist(item.getItemId())) {
			return "item already registered with id:" + item.getItemId();
		}

		item.setCustId(cust.getCustId());
		// item saving into data base
		service.saveItem(item);
		return "item saved with id:" + item.getItemId();
	}
}
