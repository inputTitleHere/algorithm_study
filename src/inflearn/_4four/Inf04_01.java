package inflearn._4four;

import java.util.*;
public class Inf04_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Character, Integer> vote = new HashMap<Character, Integer>(5);
		vote.put('A', 0);
		vote.put('B', 0);
		vote.put('C', 0);
		vote.put('D', 0);
		vote.put('E', 0);
		
		sc.nextLine(); // nextInt 다음
		char[] in = sc.nextLine().toCharArray();
		for(char c : in) {
			vote.put(c, vote.get(c)+1);
		}
		int max=0;
		char maxc=' ';
		for(char c: vote.keySet()) {
			int cnt =vote.get(c); 
			if(cnt>max) {
				maxc=c;
				max=cnt;
			}
		}
		System.out.println(maxc);
	}
}
