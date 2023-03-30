package baekjoon.gold.four;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main_2239_백승윤 {
	static int[][] sudoku;
	static List<int[]> zeros;
	static boolean[][] row = new boolean[9][10];
	static boolean[][] col = new boolean[9][10];
	static boolean[][] block = new boolean[9][10];
	
	public static void main(String[] args) throws IOException {
		sudoku = new int[9][9];

		// 몇번 줄 무슨 숫자 사용 여부
		zeros = new ArrayList<>(81);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int next = read();
				sudoku[i][j] = next;
				if (next == 0) {
					zeros.add(new int[] { i, j });
				}
				row[i][next] = true;
				col[j][next] = true;
				int blockNo = (i/3)*3+j/3;
				block[blockNo][next]=true;
			}
		}
		dfs(0);
	}

	private static boolean dfs(int curr) {
		if(curr==zeros.size()) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			return true;
		}
		
		int[] pos = zeros.get(curr);
		for(int i=1;i<10;i++) {
			int blockNo = (pos[0]/3)*3+pos[1]/3;
			if(!(row[pos[0]][i] || col[pos[1]][i] || block[blockNo][i])) { // 사용가능한 숫자면
				sudoku[pos[0]][pos[1]]=i;
				row[pos[0]][i]=true;
				col[pos[1]][i]=true;
				block[blockNo][i]=true;
				if(dfs(curr+1)) {
					return true;
				}
				row[pos[0]][i]=false;
				col[pos[1]][i]=false;
				block[blockNo][i]=false;
			}
		}
		return false;
	}

	private static int read() throws IOException {
		int n=0;
		while((n=System.in.read())<32);
		n&=15;
		return n;
	}
}
