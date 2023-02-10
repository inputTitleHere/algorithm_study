package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			int tc = Integer.parseInt(br.readLine());
			Queue<Integer> q = new LinkedList<Integer>();
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int min = Integer.MAX_VALUE;
			while(stk.hasMoreTokens()) {
				int next = Integer.parseInt(stk.nextToken());
				min=Math.min(min, next); // 빼기용 최솟값 찾기
				q.offer(next); 
			}
			int subtract = min-(min%30); // 사이클 시작점이 다시 0번으로 돌아올때 까지 각각 숫자에서 15씩 빠짐 -> 약간의 여유를 위해 30이하를 남김.
			for(int i=0;i<q.size();i++) {
				q.offer(q.poll()-subtract); // 일괄 빼기
			}
			
			subtract=0;
			while(true) {
				int decode = q.poll()-((subtract++%5)+1); // 5단위로 주기 리셋을 위해 모듈러 사용
				if(decode<=0) {
					q.offer(0);
					break;
				}
				q.offer(decode);
			}
			sb.append("#").append(tc).append(" ");
			while(!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
