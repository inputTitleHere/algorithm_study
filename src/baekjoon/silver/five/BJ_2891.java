package baekjoon.silver.five;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2891 {
	// 실버 5
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int s = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		
		int[] teams = new int[n+2];
		Arrays.fill(teams, 1);
		
		stk = new StringTokenizer(br.readLine());
		for(int i=0;i<s;i++) {
			int t=Integer.parseInt(stk.nextToken());
			teams[t]--;
		}
		
		stk = new StringTokenizer(br.readLine());
		for(int i=0;i<r;i++) {
			int t = Integer.parseInt(stk.nextToken());
			teams[t]++;
		}
		
		for(int i=1;i<=n;i++) {
			if(teams[i]==0) {
				if(teams[i-1]==2) {
					teams[i-1]--;
					teams[i]++;
				}else if(teams[i+1]==2) {
					teams[i+1]--;
					teams[i]++;
				}
			}
		}
		int cnt=0;
		for(int i=1;i<=n;i++) {
			if(teams[i]==0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
