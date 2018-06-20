package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ITransactionDao;
import com.app.model.Transaction;
import com.app.service.ITransactionservice;

@Service
public class TransactionServiceImpl implements ITransactionservice {

	@Autowired
	private ITransactionDao dao;
	public int saveTransaction(Transaction tx) {
		
		return dao.saveTransaction(tx);
	}
@Override
public Transaction getTxById(int txId) {
	
	return dao.getTxIdExist(txId);
}
}
