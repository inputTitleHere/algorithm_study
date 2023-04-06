package swea.d3;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_5607_백승윤 {
	static long[] helpme;
	static int ptr=1;
	static final int MAGIC = 1234567891;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		helpme = new long[1000001];
		helpme[0] = 1;
		int tc = Integer.parseInt(br.readLine());
		int rt = tc;
		while (tc-- > 0) {
			sb.append("#").append(rt - tc).append(" ");
			StringTokenizer stk = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			
			// n! / r!*(n-r)!
			long res = (factorial(n)/(factorial(r)*factorial(n-r)))%MAGIC;
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	static long factorial(int n) {
		
		if(n>ptr) {
			while(n>=ptr) {
				helpme[ptr]=(helpme[ptr-1]*ptr)%MAGIC;
				ptr++;
			}
		}
		System.out.println("run for "+n);
		System.out.println(helpme[n]);
		return helpme[n];
	}

}
