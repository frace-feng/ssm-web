package com.example.demo.entity;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
	public static final String KEY_MD5 = "MD5";   

	public static  String  getResult(String inputStr)
	{
	    BigInteger bigInteger=null;
	    try {
	     MessageDigest md = MessageDigest.getInstance(KEY_MD5);   
	     byte[] inputData = inputStr.getBytes(); 
	     md.update(inputData);   
	     bigInteger = new BigInteger(md.digest());   
	    } catch (Exception e) {e.printStackTrace();}
	    return bigInteger.toString(16);//返回此 BigInteger 的给定基数16进制的字符串表示形式。
	}

}
