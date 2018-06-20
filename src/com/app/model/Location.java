package com.app.model;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Table(name="loc_tab")
@Entity
public class Location implements Comparable<Location>{
	@Id
	@Column(name="id")
private int locId;
	
	
	@Column(name="d")
	@Temporal(TemporalType.TIMESTAMP)
	private Date d;
	@Column(name="name")
private String locName;
	@Column(name="type")
private String locType;
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	@Column(name="pin")
	private String pinCode;
	@Column(name="stypes")
	private String shippingTypes;
	
	
	@Column(name="cdetails")
	private String contactDetails;
	
	@Column(name="pcode")
	private String processpCode;
	
	public int getLocId() {
		return locId;
	}
	@Override
	public int compareTo(Location ob) {
		
		return this.locId-ob.locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public String getLocType() {
		return locType;
	}
	public void setLocType(String locType) {
		this.locType = locType;
	}
	public Location(int locId) {
		super();
		
		this.locId = locId;
	}
	@Override
	public String toString() {
		return "Location [locId=" + locId + ", d=" + d + ", locName=" + locName
				+ ", locType=" + locType + ", pinCode=" + pinCode
				+ ", shippingTypes=" + shippingTypes + ", contactDetails="
				+ contactDetails + ", processpCode=" + processpCode + "]";
	}
	
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getShippingTypes() {
		return shippingTypes;
	}
	public void setShippingTypes(String shippingTypes) {
		this.shippingTypes = shippingTypes;
	}
	public String getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	public String getProcesspCode() {
		return processpCode;
	}
	public void setProcesspCode(String processpCode) {
		this.processpCode = processpCode;
	}
	public Location() {
		super();
	}

}
