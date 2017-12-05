package com.kosta.util;

public class CreateBranchNum {
	public static String createBranchNum(String branchName,String branchLatitude,String branchLongitude) {
		int ascii[] = new int[branchName.length()]; 
		String asciiStr = "";
		String branchNum = "";
		for (int i =0;i<branchName.length();i++) {
			ascii[i] = (int)branchName.charAt(i);
		}
		for (int i =0;i<ascii.length;i++) {
			asciiStr+=ascii[i];
		}
		for (int i = 0; i < 2; i++) {
			branchNum+=branchLatitude.charAt(i);
		}
		for (int i = 0; i < 3; i++) {
			branchNum+=branchLongitude.charAt(i);
		}
		branchNum+="#";
		branchNum += asciiStr;
		return branchNum;
	}
}
