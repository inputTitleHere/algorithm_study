package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = null;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken()); // 과자 개수
			int m = Integer.parseInt(stk.nextToken()); // 무게제한
			int[] snacks = new int[n];
			stk = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				snacks[i]=Integer.parseInt(stk.nextToken());
			}
			Arrays.sort(snacks); // 정렬 nLogn
			int lt=0;
			int rt=n-1;
			int curr = -1; // 무게 총합
			int sum = 0;
			while(lt<rt) {
				sum=snacks[lt]+snacks[rt];
				if(sum<=m) {
					curr = Math.max(curr, sum);
					lt++;
				}else {
					rt--;
				}
			}
			sb.append(curr).append("\n");
		}
		System.out.println(sb.toString());
	}
}
