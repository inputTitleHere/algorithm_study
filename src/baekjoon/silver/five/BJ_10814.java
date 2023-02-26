package baekjoon.silver.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Member[] ls = new Member[n];
		StringTokenizer stk;
		for(int i=0;i<n;i++) {
			stk = new StringTokenizer(br.readLine());
			ls[i]=new Member(Integer.parseInt(stk.nextToken()),stk.nextToken(),i);
		}
		Arrays.sort(ls);
		StringBuilder sb = new StringBuilder();
		for(Member m : ls) {
			sb.append(m.age).append(" ").append(m.name).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static class Member implements Comparable<Member> {
		int age;
		String name;
		int regOrder;

		public Member(int age, String name, int regOrder) {
			this.age = age;
			this.name = name;
			this.regOrder = regOrder;
		}

		@Override
		public int compareTo(Member o) {
			if (this.age == o.age) {
				return this.regOrder - o.regOrder;
			}
			return this.age - o.age;
		}
	}
}
