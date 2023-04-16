package baekjoon._contest.AGCU_1st;

import java.io.*;
import java.util.*;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		int step = 1; // 1마리 생성하는 걸로 시작.
		long cat = 1L;
		
		if(n==0) {
			System.out.println(0);
			return;
		}
		
		while(cat!=n) {
			if((cat<<1) < n) {
				cat<<=1;
				step++;
			}else {
				cat+=(n-cat);
				step++;
			}
		}
		System.out.println(step);
	}
}
