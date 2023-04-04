package baekjoon.silver.five;

import java.io.IOException;
public class BJ_1427 {
	public static void main(String[] args) throws IOException{
		int[] occurence = new int[10];
		int c;
		while((c = System.in.read())>32) {
			occurence[c&15]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=9;i>=0;i--) {
			for(int j=0;j<occurence[i];j++) {
				sb.append(i);
			}
		}
		System.out.println(sb.toString());
	}
}
