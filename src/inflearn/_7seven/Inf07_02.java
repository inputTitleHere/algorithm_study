package inflearn._7seven;

import java.util.*;
public class Inf07_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		binarify(sc.nextInt());
		sc.close();
	}
	
	static void binarify(int n) {
		if(n==0) return ;
		binarify(n/2);
		System.out.print(n%2);
	}
	
}
