package com.kosta.util;

import java.util.Random;

public class CreateDoorLockNum {
	public static String doorLockNumGenerate() {
		Random r = new Random();		
		char arr[] = new char[6]; 
		for (int i = 0; i < arr.length; i++) {
			if(r.nextInt(4) == 1) {
				arr[i] = (char)(r.nextInt(26)+65);
			}else if(r.nextInt(4) == 2) {
				arr[i] = (char)(r.nextInt(26)+97);
			}else {
				arr[i] = (char)(r.nextInt(10)+48);
			}
		}
		String doorLockNum = "";
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == '5') {
				arr[i]='a';
			}
			doorLockNum += arr[i];
		}
		return doorLockNum;
	}
	public static String passwordGenerate() {
		Random r = new Random();		
		char arr[] = new char[6]; 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (char)(r.nextInt(9)+49);
		}
		String doorLockPassword = "";
		for (int i = 0; i < arr.length; i++) {
			doorLockPassword += arr[i];
		}
		return doorLockPassword;
	}
}
