package com.bms.reader.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright(C) 
 *
 * Module: 
 * @author  
 * @version
 * @see
 * @description: <MD5加密>
 * @log:
 */
public class MD5 {

	public static String getMD5(String key) {
        String result = "";
        if (key != null) {
            try {
                // 指定加密的方式为MD5
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 进行加密运算
                byte bytes[] = md.digest(key.getBytes());
                for (int i = 0; i < bytes.length; i++) {
                    // 将整数转换成十六进制形式的字符串 这里�?0xff进行与运算的原因是保证转换结果为32�?
                    String str = Integer.toHexString(bytes[i] & 0xFF);
                    if (str.length() == 1) {
                        str += "F";
                    }
                    result += str;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return result.toUpperCase();
	}

	 
	public static void main(String args[]) {
		System.out.println(getMD5(""));
	}
}
