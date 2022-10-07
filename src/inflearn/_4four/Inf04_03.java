package inflearn._4four;

import java.util.*;
public class Inf04_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] type = new int[n];
		for(int i=0;i<n;i++) {
			type[i]=sc.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		int lt = 0;
		int rt = k;
		// 초기 세팅
		Map<Integer, Integer> rmap = new HashMap<Integer, Integer>();
		for(int i=0;i<k;i++) {
			if(!rmap.containsKey(type[i])) {
				rmap.put(type[i], 1);				
			}else {
				rmap.put(type[i], rmap.get(type[i])+1);
			}
		}
		sb.append(rmap.size()).append(" ");
		
		// 첫값 이후로
		for(int i=rt;i<n;i++) {
			if(!rmap.containsKey(type[i])) {
				rmap.put(type[i], 1);
			}else {
				rmap.put(type[i], rmap.get(type[i])+1);
			}
			if(rmap.get(type[lt])==1) {
				rmap.remove(type[lt]);
			}else {
				rmap.put(type[lt],rmap.get(type[lt])-1);
			}
			lt++;
			sb.append(rmap.size()).append(" ");
		}
		System.out.println(sb.toString());
	}
}
