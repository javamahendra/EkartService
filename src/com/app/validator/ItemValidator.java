package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Item;
import com.app.service.IItemService;

@Component
public class ItemValidator {
	@Autowired
	private IItemService service;
	
	public boolean isIdExist(int itemId){
		boolean flag=false;
		Item item=service.getItemByItemId(itemId);
		if(item!=null)
		{
			flag=true;
		}
		return flag;
	}
}
