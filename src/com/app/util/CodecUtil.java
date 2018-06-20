package com.app.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class CodecUtil {
	
public String doEncode(String str)
{


	return new String(Base64.encodeBase64(str.getBytes()));
}
public String doDecode(String str){
	
	return new String(Base64.decodeBase64(str.getBytes()));
}
}
