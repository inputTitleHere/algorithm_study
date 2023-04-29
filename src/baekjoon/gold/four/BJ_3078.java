package baekjoon.gold.four;

import java.io.*;
import java.util.*;

public class BJ_3078 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		long cnt=0;
		int[] lentable = new int[21]; // 최대 20글자
		Queue<Integer> que = new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			int nextLen = br.readLine().length();
			cnt+=lentable[nextLen];
			
			if(que.size()==m) {
				lentable[que.poll()]--;
			}
			que.offer(nextLen);
			lentable[nextLen]++;
		}
		System.out.println(cnt);
	}
}
