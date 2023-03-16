package baekjoon.bronze.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10989 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		for(int i=0;i<n;i++) {
			input[i]=Integer.parseInt(br.readLine());
		}
		Arrays.stream(input).sorted().forEach((i)->{
			sb.append(i).append("\n");
		});
		System.out.println(sb.toString());
	}
}
