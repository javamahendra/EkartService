package com.app.dao;

import com.app.model.Transaction;

public interface ITransactionDao {
	public int saveTransaction(Transaction tx);

	public Transaction getTxIdExist(int txId);
}
