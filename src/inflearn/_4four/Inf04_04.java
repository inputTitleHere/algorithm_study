package inflearn._4four;

import java.util.*;
public class Inf04_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] in = sc.nextLine().toCharArray();
		char[] find = sc.nextLine().toCharArray();
		// toFind빌드
		Map<Character, Integer> toFind = new HashMap<Character, Integer>();
		Map<Character, Integer> curr = new HashMap<Character, Integer>();
		
		for(char c : find) {
			toFind.put(c, toFind.get(c)!=null?toFind.get(c)+1:1);
		}
		// 해결부
		int ans =0;
		for(int i=0;i<find.length;i++) {
			curr.put(in[i], curr.get(in[i])!=null?curr.get(in[i])+1:1);
		}
		if(toFind.equals(curr)) ans++;
		
		int lt =0;
		for(int rt=find.length;rt<in.length;rt++) {
			curr.put(in[rt],curr.get(in[rt])==null?1:curr.get(in[rt])+1);
			if(curr.get(in[lt])==1) {
				curr.remove(in[lt]);
			}else {
				curr.put(in[lt], curr.get(in[lt])-1);
			}
			lt++;
			if(toFind.equals(curr)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
