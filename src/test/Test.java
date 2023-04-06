package test;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		char[] carr = new char[10];
		
		carr[0]='A';
		carr[1]='A';
		carr[2]='A';
		String s= new String(carr);
		
		System.out.println(s.length());
		System.out.println(s.trim().length());
	}
}
