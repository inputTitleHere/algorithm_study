package baekjoon._contest.GEC_Cup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GEC_4 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		long x = Long.parseLong(stk.nextToken());
		long n = Long.parseLong(stk.nextToken());
		long t=0L;
		
		long prev=-1L;
		
		while(t!=n) {
			prev=x;
			if(x%2==0) {
				x=(x/2)^6;
			}else {
				x=(2*x)^6;
			}
			
			if(x==prev) {
				break;
			}
			t++;
		}
		System.out.println(x);
	}
}
/*

1001
500^6







*/