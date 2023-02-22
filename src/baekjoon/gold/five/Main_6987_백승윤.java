package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// java 11 : 124ms
public class Main_6987_백승윤 {
	static StringBuilder sb = new StringBuilder();
	static int[][] teams;
	static boolean globalRes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		MAIN: for (int tc = 0; tc < 4; tc++) {
			stk = new StringTokenizer(br.readLine());
			teams = new int[6][3];
			int draw = 0;
			for (int i = 0; i < 6; i++) {
				int sum = 0;
				for (int j = 0; j < 3; j++) {
					int next = Integer.parseInt(stk.nextToken());
					teams[i][j] = next;
					sum+=next;
					if(j==1) {
						draw+=next;
					}
				}
				if (sum != 5) { // 그냥 짝이 안맞는 경우
					sb.append(0).append(" ");
					continue MAIN;
				}
			}
			if(draw%2==1) { // 비기기 짝이 안맞는 경우
				sb.append(0).append(" ");
				continue MAIN;
			}
			globalRes=false;
			dfs(0, 1);
			if(globalRes) {
				sb.append(1).append(" ");
			}else {
				sb.append(0).append(" ");
			}

		}
		System.out.println(sb.toString());
	}

	private static void dfs(int atk, int def) {
		if(atk==4 && def == 6) { // 끝일 때
			int checksum = 0;
			for(int[] arr : teams) {
				for(int i : arr) {
					checksum+=i;
				}
			}
			if(checksum==0) {
				globalRes=true;
			}
			return;
		}
		if(def==6) {
			dfs(atk+1,atk+2);
			return;
		}
		
		// atk가 이기고 def가 패배
		if(teams[atk][0]>0 && teams[def][2]>0) {
			teams[atk][0]--;
			teams[def][2]--;
			dfs(atk,def+1);
			teams[atk][0]++;
			teams[def][2]++;
		}
		// atk와 def비기기
		if(teams[atk][1]>0 && teams[def][1]>0) {
			teams[atk][1]--;
			teams[def][1]--;
			dfs(atk,def+1);
			teams[atk][1]++;
			teams[def][1]++;
		}
		// atk가 def에게 패배
		if(teams[atk][2]>0 && teams[def][0]>0) {
			teams[atk][2]--;
			teams[def][0]--;
			dfs(atk,def+1);
			teams[atk][2]++;
			teams[def][0]++;
		}
	}
}
