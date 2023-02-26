package baekjoon._contest.제1흐즈로컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HZRCup_A2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stk.nextToken()); // x
		int m = Integer.parseInt(stk.nextToken()); // y

		StringBuilder sb = new StringBuilder();
		
		if (n % 2 == 0 || m % 2 == 0) {
			sb.append(n * m).append("\n");
			// 가로 -> n, 세로 -> m
			// 시작은 1 1
			sb.append(1).append(" ").append(1).append("\n");
			if((n%2==0 && m%2==0) || (n%2!=0 && m%2==0)) { // 둘다 짝수 또는 세로가 짝수
				int x=2;
				int y=1;
				while(y<=m) {
					while(x<=n) {
						sb.append(x++).append(" ").append(y).append("\n");
					}
					x--;
					y++; // 한칸아래로
					while(x>1) {
						sb.append(x--).append(" ").append(y).append("\n");
					}
					if(y!=m) {
						x++;
					}
					y++;
				}
				y--; // 박으로 나간거 돌아오기
				while(y>1) {
					sb.append(x).append(" ").append(y--).append("\n");
				}
			}else { // 가로가 짝수
				int x=1;
				int y=2;
				while(x<=n) {
					while(y<=m) {
						sb.append(x).append(" ").append(y++).append("\n");
					}
					x++;
					y--;
					while(y>1) {
						sb.append(x).append(" ").append(y--).append("\n");
					}
					if(x!=n) {
						y++;
					}
					x++;
				}
				x--; // 박으로 나간거 돌아오기
				while(x>1) {
					sb.append(x--).append(" ").append(y).append("\n");
				}
			}
		} else {// 둘다 홀수
			sb.append(n * m - 1).append("\n");
			sb.append(1).append(" ").append(1).append("\n");
			int x=2;
			int y=1;
			
			while(y<=m-2) {
				while(x<=n) { // 앞으로
					sb.append(x++).append(" ").append(y).append("\n");
				}
				x--;
				y++;
				if(y>m-2) {
					break;
				}
				while(x>1) {
					sb.append(x--).append(" ").append(y).append("\n");
				}
				x++;
				y++;
			}
			// 지그재그 구간.
			while(x>1) {
				sb.append(x).append(" ").append(y++).append("\n");
				sb.append(x--).append(" ").append(y).append("\n");
				sb.append(x).append(" ").append(y--).append("\n");
				sb.append(x--).append(" ").append(y).append("\n");
			}
			while(y>1) {
				sb.append(x).append(" ").append(y--).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
