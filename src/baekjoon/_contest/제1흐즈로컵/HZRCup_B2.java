package baekjoon._contest.제1흐즈로컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 실패!!
public class HZRCup_B2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		Long bitmask = 0L;
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			char sig = s.charAt(0);
			if(sig=='+') {
				bitmask+=Long.parseLong(s.substring(1));
			}else { // 빼기
				bitmask-=Long.parseLong(s.substring(1));
			}
			
			if(bitmask==0) {
				sb.append(0).append("\n");
				continue;
			}
			long max=0L;
			for(int j=62;j>0;j--) {
				if(((1<<j) & bitmask) !=0) {
					max=1<<j;
				}
			}
			sb.append(max).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
