package baekjoon.silver.four;

import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ_1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());

		Set<Integer> aset = new TreeSet<Integer>();
		Set<Integer> bset = new TreeSet<Integer>();

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			aset.add(Integer.parseInt(stk.nextToken()));
		}
		
		int unique=0;
		
		stk = new StringTokenizer(br.readLine());
		for(int i=0;i<b;i++) {
			int next = Integer.parseInt(stk.nextToken());
			bset.add(next);
			if(!aset.contains(next)) {
				unique++;
			}
		}
		for(int i : aset) {
			if(!bset.contains(i)) {
				unique++;
			}
		}
		System.out.println(unique);

	}
}
