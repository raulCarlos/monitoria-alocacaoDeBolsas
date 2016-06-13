package br.com.unb.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptor {
	
	private static MessageDigest md = null;
	
	static{
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	private static char[] hexCode(byte[] text){
		char[] hexOutput = new char[text.length * 2];
		String hexString;
		
		for(int i = 0; i < text.length; i++){
			hexString = "00" + Integer.toHexString(text[i]);
			hexString.toUpperCase().getChars(hexString.length() - 2, hexString.length(), hexOutput, i * 2);
		}
		return hexOutput;
	}
	
	public static String encrypt(String pwd){
		if(md != null){
			return new String(hexCode(md.digest(pwd.getBytes())));
		}
		return null;
	}
}
