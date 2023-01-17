package swea.d3;

import java.util.Scanner;

public class SWEA_15941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1;tc<=t;tc++) {
			int l = sc.nextInt();
			System.out.printf("#%d %d\n",tc,l*l);
		}
		sc.close();
	}
}
