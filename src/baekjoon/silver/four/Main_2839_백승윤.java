package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// java 11 : 124ms
// java  8 :  80ms
public class Main_2839_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = funParseStringToInt(br.readLine());
		
		int f = n/5;
		int t = (n%5)/3;
		
		while(f>-1) {
			if(f*5+t*3 < n) {
				t=(n-(--f*5))/3;
			}else {
				break;
			}
		}
		if(f==-1) {
			System.out.println(-1);
		}else {
			System.out.println(f+t);
		}
	}
	
	static int funParseStringToInt(String in) {
		char[] carr = in.toCharArray();
		int res = 0;
		int zero = '0';
		int add = 1;
		for(int i=carr.length-1;i>-1;i--) {
			res+=add*(carr[i]-zero);
			add*=10;
		}
		return res;
	}
}
