package com.gyb.spring.mongodb.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * Base64 加解密工具类
 * @author Administrator
 *
 */
public class DESUtil {
	private static final Key key;
	private static final String KEY_STR = "mykey";

	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(KEY_STR.getBytes());
			generator.init(secureRandom);
			key = generator.generateKey();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对字符串进行加密，返回BASE64的加密字符串
	 */
	public static String encryptString(String str) {
		Base64.Encoder base64Encoder = Base64.getEncoder();
		try {
			byte[] strBytes = str.getBytes(StandardCharsets.UTF_8);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return base64Encoder.encodeToString(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对BASE64加密字符串进行解密 <功能详细描述>
	 */
	public static String decryptString(String str) {
		Base64.Decoder base64Decoder = Base64.getDecoder();
		try {
			byte[] strBytes = base64Decoder.decode(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return new String(encryptStrBytes, StandardCharsets.UTF_8);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		String name = "root";
		String password = "123456";
		String encryname = encryptString(name);
		String encrypassword = encryptString(password);
		System.out.println(encryname);
		System.out.println(encrypassword);

		System.out.println(decryptString(encryname));
		System.out.println(decryptString(encrypassword));
	}
}