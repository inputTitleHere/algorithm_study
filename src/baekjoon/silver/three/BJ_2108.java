package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<Integer> l = new ArrayList<>(n);
		// 입력된 정수의 절댓값은 4,000을 넘지 않는다.
		int[] tracker = new int[8001];
		int sum=0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(br.readLine());
			
			// 범위용
			if(next>max) max=next;
			if(next<min) min=next;
			
			sum+=next; // 산술평균용
			tracker[next+4000]++; // 최빈용
			l.add(next); // 중앙값용
		}
		
		// 최빈값 2번째 작은거
		int most=Integer.MIN_VALUE;
		int fir=-1;
		int sec=-1;
		
		for(int i=0;i<8001;i++) {
			if(tracker[i]>most) {
				most=tracker[i];
				fir=i;
				sec=-1;
			}else if (tracker[i]==most) {
				if(sec==-1) {
					sec=i;
				}
			}
		}
		int occ = sec==-1?fir:sec;
		occ-=4000;
		int avg = (int) Math.round((double)sum/n);
		Collections.sort(l);
		int mid = l.get(n/2);
		
		StringBuilder sb = new StringBuilder();
		sb.append(avg).append("\n").append(mid).append("\n").append(occ).append("\n").append(max-min);
		System.out.println(sb.toString());
		
	}
}
