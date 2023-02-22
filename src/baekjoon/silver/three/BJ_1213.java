package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Character> pq = new PriorityQueue<>();
		for (char c : br.readLine().toCharArray()) {
			pq.add(c);
		}
		char[] res = new char[pq.size()];
		int l = 0;
		int r = res.length - 1;

		char tmp = 0;

		while (l < r && pq.size()>1) {
			char c1 = pq.poll();
			char c2 = pq.poll();
			if (c1 != c2) {
				
				if(tmp==0) {
					tmp=c1;
					if(pq.isEmpty()) {
						System.out.println("I'm Sorry Hansoo");
						return;																	
					}
					c1=pq.poll();
					if(c1!=c2) {
						System.out.println("I'm Sorry Hansoo");
						return;											
					}
				}else {
					System.out.println("I'm Sorry Hansoo");
					return;					
				}
			}
			res[l++] = c1;
			res[r--] = c2;
		}
		if(l<r && pq.size()<=1) {
			System.out.println("I'm Sorry Hansoo");
			return;		
		}
		
		if (l == r) { // 홀수개일 때
			if(pq.isEmpty()) {
				res[l]=tmp;
			}else {
				res[l] = pq.poll();
			}				
		}
		System.out.println(new String(res));
	}
}
