package baekjoon.bronze.one;

import java.io.IOException;

public class BJ_3041 {
	public static void main(String[] args) throws IOException {
		int sum = 0;
		for (int i = 0; i < 16; i++) {
			int read = readchar();
			if ((read ^ 15) != 0) {
				int y = (read / 4) - (i / 4);
				if((y&(1<<31))!=0) {
					y=~y+1;
				}
				int x = (read % 4) - (i % 4);
				if((x&(1<<31))!=0) {
					x=~x+1;
				}
				sum+=y+x;
			}
		}
		System.out.println(sum);
	}

	static int readchar() throws IOException {
		int n = System.in.read();
		while (n < 46)
			n = System.in.read();
		if (n > 64) {
			return (n & 31) - 1;
		} else {
			return 15;
		}
	}
}
