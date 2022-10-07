package inflearn._2two;

import java.util.*;
public class Inf02_05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int counter =0;
		// 소수 아니면 true
		boolean[] arr = new boolean[n+1]; 
		arr[0]=arr[1]=true; 
		for(int i=2;i<=n;i++) { 
			if(!arr[i]) {
				counter++;
				int l=2;
				int m=i*l; 
				while(m<=n) { 
					arr[m]=true;  
					m=i*++l; 
				}
			}
		}
		System.out.println(counter);
	}
}
