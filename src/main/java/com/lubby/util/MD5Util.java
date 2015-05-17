package com.lubby.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Lubby
 * @date 2015年3月23日 下午9:09:35
 *
 */


/**
 * 
 * 
 * 
 * 可以通过  new BigInteger(bytes[] data)   ;   BigInteger.toString(16);来把128位二进制转换成32个16进制数
 *
 */
public class MD5Util {
	public static void main(String[] args){
		String meg= "liubin";
		System.out.println(getMD5(meg));
	}

	public static String getMD5(String message) {
		String md5Str = "";

		// 1.创建MD5信息摘要算法对象
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");

			// 2.信息转换成byte数组
			byte[] messageByte = message.getBytes();
			// 3.获得128位摘要
			byte[] md5Byte = md.digest(messageByte);

			// 4.把每一个字节转换成16进制 128/8 = 16个16进制数
			md5Str = bytesToHex(md5Byte);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return md5Str;
	}

	public static String bytesToHex(byte[] bytes) {
		StringBuffer md5Str = new StringBuffer();
		int digital;
		for (byte b : bytes) {
			digital = b;
			if (digital < 0) {
				digital += 256;
			}
			if (digital < 16) {
				md5Str.append(0);
			}
			md5Str.append(Integer.toHexString(digital));
		}

		return md5Str.toString();
	}
}
