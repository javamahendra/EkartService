package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Transaction;
import com.app.service.ITransactionservice;
@Component
public class TransactionValidator {
@Autowired
private ITransactionservice service;
public boolean isTxIdExist(int txId){
	boolean flag=false;
	Transaction tx=service.getTxById(txId);
	if(tx!=null){
		flag=true;
	}
	return flag;
}
}
