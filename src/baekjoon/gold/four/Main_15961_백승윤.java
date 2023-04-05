package baekjoon.gold.four;

import java.io.*;

// Java 11 : 328ms ㅋㅋㅋㅋㅋㅋㅋ
public class Main_15961_백승윤 {
	public static void main(String[] args) throws IOException {
		int n = read();
		int d = read();
		int k = read();
		int c = read();

		int[] cnt = new int[d + 1];
		int[] firstSelection = new int[k];
		int[] sel = new int[n+k];
		int unique = 0;
		for (int i = 0; i < k; i++) {
			int next = read();
			if (cnt[next] == 0) {
				unique++;
			}
			cnt[next]++;
			firstSelection[i] = next;
			sel[i]=next;
		}
		int max = unique;
		for (int i = k; i < n; i++) {
			int next = read();
			if(cnt[next]==0) {
				unique++;
			}
			cnt[next]++;
			sel[i]=next;
			if(cnt[sel[i-k]]==1) {
				unique--;
			}
			cnt[sel[i-k]]--;
			
			if(cnt[c]==0) {
				max=Math.max(max, unique+1);
			}else {
				max=Math.max(max, unique);
			}
		}
		// 마무리;
		for(int i=0;i<k;i++) {
			int next = firstSelection[i];
			if(cnt[next]==0) {
				unique++;
			}
			cnt[next]++;
			sel[n+i]=next;
			
			if(cnt[sel[n+i-k]]==1) {
				unique--;
			}
			cnt[sel[n+i-k]]--;
			
			if(cnt[c]==0) {
				max=Math.max(max, unique+1);
			}else {
				max=Math.max(max, unique);
			}
		}
		System.out.println(max);
	}
	
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		// 내가 추가.
		if (c == 13)
			System.in.read(); // 윈도우때문에 -> 백준이 리눅스 기반으로 알고있음. 이거 필요없음.
		return n;
	}
}
