package com.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ITransactionDao;
import com.app.model.Transaction;
@Repository
public class TransactionDaoImpl implements ITransactionDao{
	@Autowired
	private HibernateTemplate ht;
	
	public int saveTransaction(Transaction tx) {
		
	
		return (Integer)ht.save(tx);
	}
	@Override
	public Transaction getTxIdExist(int txId) {
		
		return ht.get(Transaction.class,txId);
	}

}
