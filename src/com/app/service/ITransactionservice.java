package com.app.service;

import com.app.model.Transaction;

public interface ITransactionservice {
	public int saveTransaction(Transaction tx);
	public Transaction getTxById(int txId);
}
