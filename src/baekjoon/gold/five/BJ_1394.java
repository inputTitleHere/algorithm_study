package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BJ_1394 {

	static char[] pwd;
	static int pwdHash;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Integer> pos = new TreeMap<>();
		char[] memo = br.readLine().toCharArray();
		for(int i=1;i<=memo.length;i++) {
			pos.put(memo[i-1], i);
		}
		pwd = br.readLine().toCharArray();

		final int MAGIC = 900528;
		
		int push =0;
		for(int i=0;i<pwd.length;i++) {
			push *= memo.length; 
			push += pos.get(pwd[i]);
			push %= MAGIC;
		}
		System.out.println(push);
	}
}
