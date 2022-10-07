package inflearn._2two;

import java.util.*;

public class Inf02_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] input = sc.nextLine().split("\\s");
		int curr=0;
		int counter=0;
		for(String s : input) {
			int in = Integer.parseInt(s);
			if(in>curr) {
				counter++;
				curr=in;
			}
			
		}
		System.out.println(counter);
	}
}
