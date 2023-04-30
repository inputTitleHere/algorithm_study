package baekjoon.bronze.four;

import java.io.*;
import java.util.*;

public class BJ_27267 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		int d = Integer.parseInt(stk.nextToken());
		
		int car = a*b;
		int pet = c*d;
		if(car>pet) {
			System.out.println("M");
		}else if (car<pet) {
			System.out.println("P");
		}else {
			System.out.println("E");
		}
		
	}
}
