package com.app.dao;

import com.app.model.Item;

public interface IItemDao {

	public int saveItem(Item item);
	public Item getItemByItemId(int itemId);
	
	
}
