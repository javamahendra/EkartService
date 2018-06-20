package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "vent_tab")
@Entity
public class Vendor implements Comparable<Vendor>{
	@Id
	@Column(name = "vid")
	private int venId;
	@Column(name = "vname")
	private String venName;
	@Column(name = "vmail")
	private String venMail;
	@Column(name = "vmobile")
	private String mobile;
	@Column(name = "vaddress")
	private String address;
	@ManyToOne
	@JoinColumn(name = "lidFk")
	private Location loc;

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public int getVenId() {
		return venId;
	}

	public void setVenId(int venId) {
		this.venId = venId;
	}

	public String getVenName() {
		return venName;
	}

	public void setVenName(String venName) {
		this.venName = venName;
	}

	public String getVenMail() {
		return venMail;
	}

	public void setVenMail(String venMail) {
		this.venMail = venMail;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Vendor(int venId) {
		super();
		this.venId = venId;
	}

	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName + ", venMail="
				+ venMail + ", mobile=" + mobile + ", address=" + address
				+ ", loc=" + loc + "]";
	}

	public Vendor() {
		super();
	}
	@Override
	public int compareTo(Vendor o) {
	
		return this.getVenId()-o.getVenId();
	}

}
