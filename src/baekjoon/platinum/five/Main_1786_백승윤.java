package baekjoon.platinum.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1786_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] t = br.readLine().toCharArray();
		char[] p = br.readLine().toCharArray();

		int pl = p.length;
		int tl = t.length;

		int[] pi = new int[pl];
		for (int i = 1, j = 0; i < pl; i++) { // pi배열(fail 배열) 빌드
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}
			if (p[i] == p[j]) {  // 일치했을 때 1 증가하기
				pi[i] = ++j;
			}
		}
		int cnt=0;
		StringBuilder sb = new StringBuilder();
		for(int i=0,j=0;i<tl;i++) {
			while(j>0 && t[i]!=p[j]) {
				j=pi[j-1];
			}
			if(t[i]==p[j]) {
				if(j==pl-1) {
					cnt++;
					j=pi[j]; // 같은 것이 여러개 있으면 매칭되는 만큼 이동하기
					sb.append(i-pl+2).append(" ");
				}else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
}
