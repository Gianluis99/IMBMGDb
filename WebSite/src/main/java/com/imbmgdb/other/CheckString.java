package com.imbmgdb.other;

import java.util.regex.Pattern;

public class CheckString {

	private static boolean macthes(String regex,String p) {
		boolean res=Pattern.matches(regex, p);
		return res;
	}
	
	
	boolean checkNum(String n) {
		
		return macthes("[0-9]+",n);
}

	
	public static boolean checkPassword(String p){
			
		return macthes("((?=.*)[a-z]*)(?=.*[A-Z]*).{6,30}", p);
		
		
	
			
		
	}
	

}
