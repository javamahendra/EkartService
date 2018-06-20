package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tx_tab")
public class Transaction {
@Id
@Column(name="tId")
	private int txId;
@Column(name="tCustName")
	private String txCustName;
@Column(name="tCost")
	private double txCost;
@Column(name="tItems")
	private String txItems;
@Column(name="tModel")
	private String txModel;
@Column(name="cId")
	private int custId;
@Override
public String toString() {
	return "Transaction [txId=" + txId + ", txCustName=" + txCustName
			+ ", txCost=" + txCost + ", txItems=" + txItems + ", txModel="
			+ txModel + ", custId=" + custId + "]";
}
public int getTxId() {
	return txId;
}
public void setTxId(int txId) {
	this.txId = txId;
}
public String getTxCustName() {
	return txCustName;
}
public void setTxCustName(String txCustName) {
	this.txCustName = txCustName;
}
public double getTxCost() {
	return txCost;
}
public void setTxCost(double txCost) {
	this.txCost = txCost;
}
public String getTxItems() {
	return txItems;
}
public void setTxItems(String txItems) {
	this.txItems = txItems;
}
public String getTxModel() {
	return txModel;
}
public void setTxModel(String txModel) {
	this.txModel = txModel;
}
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public Transaction() {
	super();
}

}
