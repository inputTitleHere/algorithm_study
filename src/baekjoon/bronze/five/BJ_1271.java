package baekjoon.bronze.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_1271 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		BigInteger n = new BigInteger(stk.nextToken());
		BigInteger m = new BigInteger(stk.nextToken());
		StringBuilder sb = new StringBuilder();
		sb.append(n.divide(m)).append("\n").append(n.mod(m));
		System.out.println(sb.toString());
	}
}
