package baekjoon._contest.UNIST_DGIST_POSTECH_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int h1 = Integer.parseInt(stk.nextToken());
		int w1 = Integer.parseInt(stk.nextToken());
		// 동일한 최대 구조
		// 나머지 옮기면 됨.
		char[][] ori = init(30);
		for (int i = 0; i < h1; i++) {
			char[] carr = br.readLine().toCharArray();
			System.arraycopy(carr, 0, ori[i+10], 10, w1);
		}
		int coin = 0;
		for (char[] carr : ori) {
			for (char c : carr) {
				if (c == 'O') {
					coin++;
				}
			}
		}

		stk = new StringTokenizer(br.readLine());
		int h2 = Integer.parseInt(stk.nextToken());
		int w2 = Integer.parseInt(stk.nextToken());
		char[][] target = init(10);
		for (int i = 0; i < h2; i++) {
			char[] carr = br.readLine().toCharArray();
			System.arraycopy(carr, 0, target[i], 0, w2);
		}
		
		int max = 0;
		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j <= 20; j++) {
				// i,j는 target에서의 탐색 시작 위치
				int match = 0;
				
				for(int k=0;k<10;k++) {
					for(int l=0;l<10;l++) {
						if(target[k][l]=='O' && ori[i+k][j+l]=='O') {
							match++;
						}
					}
				}
				max = Math.max(max, match);
			}
		}
		System.out.println(coin - max);

	}

	static char[][] init(int size) {
		if(size>30) {
			size=30;
		}
		char[][] board = new char[size][size];
		char[] init = { '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
				'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' };
		for (int i = 0; i < size; i++) {
			System.arraycopy(init, 0, board[i], 0, size);
		}
		return board;
	}
}
