package baekjoon.gold.five;

import java.io.*;

public class BJ_20437 {
	// 문자열 게임
	// it is a String Crab
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tcase = 0; tcase < t; tcase++) {
			int min = Integer.MAX_VALUE;
			int max = -1;
			String s = br.readLine();
			int len = s.length();
			char[] c = s.toCharArray();
			int k = Integer.parseInt(br.readLine());
			
			
			if(k==1) {
				sb.append(1).append(" ").append(1).append("\n");
				continue;
			}
			
			for (int target = 'a'; target <= 'z'; target++) {
				char f = (char) target;
				// lfind
				int left = s.indexOf(f);
				if (left == -1) {
					continue;
				}
				int right = left;
				
				// 초기 우측포인터 잡기
				int cnt=1;
				while(right<len-1){
					if(cnt==k) {
						break;
					}
					if(c[++right]==f) {
						cnt++;
					}
				}
				if(cnt<k) { // 끝까지 갔을텐데 개수 안맞으면 나가기
					continue;
				}
				int local = right-left+1;
				max=Math.max(max, local);
				min=Math.min(min, local);
				
//				System.out.println("=========");
//				print(c,left,right);
//				System.out.println(local);
				
				while(right<len-1) {
					while(c[++right]!=f && right<len-1);
					while(c[++left]!=f && left<right-1);
					if(c[right]!=f) {
						break;
					}
//					System.out.println("=========");
//					print(c,left,right);
					local = right-left+1;
//					System.out.println(local);					
					max=Math.max(max, local);
					min=Math.min(min, local);
				}
			}
			if (max == -1) {
				sb.append(-1).append("\n");
			} else {
				sb.append(min).append(" ").append(max).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	static void print(char[] c, int l, int r) {
		StringBuilder sb = new StringBuilder();
		for(int i=l;i<=r;i++) {
			sb.append(c[i]);
		}
		System.out.println(sb.toString());
	}
}
