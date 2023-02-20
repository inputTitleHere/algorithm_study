package baekjoon.silver.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Java  8 : 76ms
// Java 11 : 124ms 
public class Main_1074_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		
		int k = (int)Math.pow(2, n);
		System.out.println(quad(k,r,c,0));
		
	}
	
	static int quad(int n, int r, int c, int sum) {
		// 탈출조건
		if(n==1) {
			return sum;
		}
		// 1분면
		int half = n>>1;
		int pow = half*half;
		if(r<half && c<half) {
			return quad(half, r,c,sum);
		}else if(r<half && c>=half) { //  2분면
			return quad(half,r,c-half,sum+pow);
		}else if(r>=half && c<half) { // 3분면
			return quad(half,r-half,c,sum+(pow*2));
		}else { // 4분면
			return quad(half,r-half,c-half,sum+(pow*3));
		}
	}
}
