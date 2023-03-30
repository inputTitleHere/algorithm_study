package baekjoon.gold.five;

import java.io.IOException;

// java 11 : 148ms : 14624kb
// java  8 : 108ms : 12068kb
// 이상한 INPUT받는법...
public class Main_12865_백승윤 {
	public static void main(String[] args) throws IOException{
		int n = read();
		int k = read();
		int[] dp = new int[k+1];
		
		int[][] items = new int[n+1][2];
		
		ITEM : for(int i=1;i<=n;i++) {
			int wi = read();
			int pi = read();
			for(int w=k;w>0;w--) {
				if(wi > w) {
//					나머진 그대로.
					continue ITEM;
				}else {
					dp[w]=Math.max(dp[w], dp[w-wi]+pi);
				}
			}
		}
		System.out.println(dp[k]);
	}
	
	private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if(c==13) System.in.read(); // 윈도우때문에 -> 백준이 리눅스 기반으로 알고있음. 이거 필요없음.
        return n;
    }
}
