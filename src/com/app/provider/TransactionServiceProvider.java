package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Transaction;
import com.app.service.ITransactionservice;
import com.app.util.CodecUtil;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;
import com.app.validator.TransactionValidator;

@Component
@Path("/transaction")
public class TransactionServiceProvider {
	@Autowired
	private CustomerValidator customerValidator;
	@Autowired
	private JsonUtil jsonUtil;
	@Autowired
	private CodecUtil codecUtil;
	@Autowired
	private ITransactionservice Txservice;
	@Autowired
	private TransactionValidator txValidator;

	@POST
	@Path("/saveTransaction")
	public String saveTransaction(@HeaderParam("userName") String userName,
			@HeaderParam("password") String pwd,
			@HeaderParam("accessToken") String token, String jsonTx) {

		if (userName == null || "".equals(userName.trim())) {
			return "userName can't be empty or null";
		} 
		if (pwd == null || "".equals(pwd.trim())) {
			return "password can't be empty or null";
		}
		if (token == null || "".equals(token.trim())) {
			return "userName can't be empty or null";
		}
		if (jsonTx == null || "".equals(jsonTx.trim())) {
			return "json can't be empty or null";
		}
		Customer cust = customerValidator.getCustomerbyEmail(userName);
		if (cust == null) {
			return "Customer Not Exist";
		}

		if (!customerValidator.isPwdTokenExist(pwd, token, cust)) {
			return "invalid credentilas";
		}

		if (!customerValidator.isCustomerConsumer(cust)) {
			return "customer not a consumer";
		}
		Object ob = jsonUtil.JsonToObject(jsonTx, Transaction.class);
		if (ob == null) {
			return "invalid json formate";
		}

		Transaction tx = (Transaction) ob;
		tx.setTxCustName(cust.getCustName());
		tx.setCustId(cust.getCustId());
		if (txValidator.isTxIdExist(tx.getTxId())) {
			return "Transaction already saved with id" + tx.getTxId();
		}
		int txId = Txservice.saveTransaction(tx);
		return "Transaction saved witd id:" + txId;
	}
}
