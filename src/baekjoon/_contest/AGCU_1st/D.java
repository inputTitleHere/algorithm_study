package baekjoon._contest.AGCU_1st;

import java.io.*;

public class D {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] s = br.readLine().toCharArray();

		boolean isVitamin = false;
		for (int i = 1; i < n && !isVitamin; i++) { // 길이
//			System.out.println(i);
			int diff = 0;
			for(int j=0;j<i && diff<2;j++) {
//				System.out.println(s[j] + " " + s[n-i+j]);
				if(s[j]!=s[n-i+j]) {
					diff++;
				}
			}
			if(diff==1) {
				isVitamin=true;
			}
		}
		if(isVitamin) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
