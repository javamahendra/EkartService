package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="i_tab")
public class Item {
	@Id
	@Column(name="iid")
private int itemId;
	@Column(name="iname")
private String itemName;
	@Column(name="icost")
private double itemCost;
	@Column(name="cid")
private int custId;
@Override
public String toString() {
	return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemCost="
			+ itemCost + ", custId=" + custId + "]";
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public double getItemCost() {
	return itemCost;
} 
public Item() {
	super();
}
public void setItemCost(double itemCost) {
	this.itemCost = itemCost;
}
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public Item(int itemId) {
	super();
	this.itemId = itemId;
}

}

