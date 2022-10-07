package inflearn._4four;

import java.util.*;
public class Inf04_05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] in = new int[n];
		for(int i=0;i<n;i++) {
			in[i]=sc.nextInt();
		}
//		Arrays.sort(in);
		Set<Integer> add = new TreeSet<Integer>();
		// 3장을 뽑는다. 크기순으로 해보자.
		for(int i=n-1;i>=0;i--) {
			for(int j=i-1;j>=0;j--) {
				for(int l=j-1;l>=0;l--) {
					add.add(in[i]+in[j]+in[l]);
				}
			}
		}
		if(add.size()>k) {
			Integer[] res =  add.toArray(new Integer[0]);
			System.out.println(res[add.size()-k]);
		}else {
			System.out.println("-1");			
		}
	}
}
