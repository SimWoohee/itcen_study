package com.company.annotation.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncUtil {

	// 암호화 시키는 메소드 구현
	public static String encryptSHA256(String plainText) {
		// String plainText = "123123";
		String sha256 = "";
		try {
			MessageDigest mdSha256 = MessageDigest.getInstance("SHA-256");
			mdSha256.update(plainText.getBytes("utf-8"));
			byte[] sha256Hash = mdSha256.digest();
			StringBuffer hexSHA256hash = new StringBuffer();
			for (byte b : sha256Hash) {
				String hexString = String.format("%02x", b);
				hexSHA256hash.append(hexString);
			}
			sha256 = hexSHA256hash.toString();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sha256;
	}
}