package com.app.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import com.app.model.Item;

@Component
public class JsonUtil {

	public Object JsonToObject(String json, @SuppressWarnings("rawtypes") Class c) {
		Object ob = null;
		try {
			ObjectMapper om = new ObjectMapper();
			ob = om.readValue(json, Item.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}
}
