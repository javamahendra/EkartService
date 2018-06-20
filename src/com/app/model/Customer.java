package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cust_tab")
public class Customer implements Comparable<Customer> {
	@Id
	@Column(name = "cid")
	private int custId;
	@Column(name = "cname")
	private String custName;
	@Column(name = "mail")
	private String custEmail;
	@Column(name = "addr")
	private String custAddr;
	@Column(name = "type")
	private String custType;
	@Column(name = "pwd")
	private String password;
	@Column(name = "tocken")
	private String accTock;
	@ManyToOne
	@JoinColumn(name = "codFks")
	private Location loc;

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccTock() {
		return accTock;
	}

	public void setAccTock(String accTock) {
		this.accTock = accTock;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custEmail=" + custEmail + ", custAddr=" + custAddr
				+ ", custType=" + custType + ", password=" + password
				+ ", accTock=" + accTock + ", loc=" + loc + "]";
	}

	public Customer(int custId) {
		super();
		this.custId = custId;
	}

	public Customer() {
		super();
	}

	@Override
	public int compareTo(Customer o) {

		return this.getCustId() - o.getCustId();
	}
}
