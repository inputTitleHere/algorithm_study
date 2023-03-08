package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_2607 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		int match = 0;
		for (int i = 1; i < n; i++) {
			Map<Character, Integer> copy = new HashMap<>(map);
			String sn = br.readLine();
			int miss = 0;
			int snl = sn.length();
			int slen = s.length();
			if (Math.abs(snl - slen) >= 2) {
				continue;
			}
			// 길이 같을 때
			if (sn.length() == s.length()) {
				// 글자 하나 바꾸기
				for (char ch : sn.toCharArray()) {
					if(copy.containsKey(ch) && copy.get(ch)>0) {
						copy.put(ch, copy.get(ch)-1);
					}else {
						miss++;
					}
				}
				if(miss<2) {
					match++;
				}
				continue;
			}
			// 길이 하나 차이날 때
			// 다른문자+1, 같은 문자 +-1
			for (char ch : sn.toCharArray()) {
				if(copy.containsKey(ch)) {
					copy.put(ch, copy.get(ch)-1);
				}else {
					miss++;
				}
			}
			for(int ia : copy.values()) {
				miss+=Math.abs(ia);
			}
			if(miss>=2) {
				continue;
			}else {
				match++;
			}
		}
		System.out.println(match);
	}
}
