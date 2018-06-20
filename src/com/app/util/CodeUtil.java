package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {

	private String getStr(int size)
	{
		return UUID.randomUUID().toString().replace("-","").substring(0,size);
	}
	public String getPwd()
	{
		return getStr(6);
	}
	public String getToken()
	{
		return getStr(8);
	}
}
