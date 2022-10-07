package inflearn._4four;

import java.util.*;
public class Inf04_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<Character, Integer> f = new HashMap<Character, Integer>();
		char[] in = sc.nextLine().toCharArray();
		for(char c : in) {
			if(f.containsKey(c)) {
				f.put(c, f.get(c)+1);
			}else {
				f.put(c, 1);
			}
		}
		// 길이가 같은 두개의 단어이다.
		for(char c : sc.nextLine().toCharArray()) {
			if(!f.containsKey(c)){ // 있는지 없는지 체크
				System.out.println("NO");
				return;
			}
			int curr = f.get(c);
			if(curr==0) {
				System.out.println("NO");
				return;
			}
			f.put(c, f.get(c)-1);
		}
		// 길이가 같으므로 중간에서 안터지면 같을 것이다.
		System.out.println("YES");
	}
}
