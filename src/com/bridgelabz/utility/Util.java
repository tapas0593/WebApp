package com.bridgelabz.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

	public static String encryptPass(String password) {
		String passwordToHash = password;
		return getSecurePassword(passwordToHash);
	}

	private static String getSecurePassword(String passwordToHash) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
}
