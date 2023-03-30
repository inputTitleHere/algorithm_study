package baekjoon.platinum.four;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BJ_12094 {
	static int max;
	static int n;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		n = read();
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = read();
				max=Math.max(max, board[i][j]);
			}
		}
		// 한방향으로 이동했을 때 결합된게 아무것도 없으면 반대방향으로는 가지 않는다.
		dfs(board,0);
		System.out.println(max);
		
	}

	
	static void dfs(int[][] board, int step) {
		if (step == 10) {
			int local = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					local = Math.max(local, board[i][j]);
				}
			}
			
			max = Math.max(local, max);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int[][] boardCopy = copy(board);
			move(boardCopy,d);
			
			boolean moved=false;
			CHECK : for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(board[i][j]!=boardCopy[i][j]) {
						moved=true;
						break CHECK;
					}
				}
			}
			if(!moved) {
				continue;
			}
			
			dfs(boardCopy,step+1);
		}

	}
	private static void move(int[][] board, int direction) {
		Deque<Tile> deq = new ArrayDeque<>();
		if(direction==0) {
			for (int j = 0; j < n; j++) {
				for(int i=0;i<n;i++) {
					if(board[i][j]!=0) {
						if(deq.isEmpty()) {
							deq.push(new Tile(board[i][j],false));
						}else {
							Tile t = deq.peek();
							if(!t.merged && t.number==board[i][j]) {
								deq.pop();
								t.number*=2;
								t.merged=true;
								deq.push(t);
							}else {
								deq.push(new Tile(board[i][j],false));
							}
						}
					}
				}
				int pos = 0;
				while(!deq.isEmpty()) {
					board[pos++][j]=deq.pollLast().number;
				}
				for(int k=pos;k<n;k++) {
					board[k][j]=0;
				}
			}
		}else if(direction==1) {
			for (int i = 0; i < n; i++) {
				for (int j = n-1; j >= 0; j--) {
					if(board[i][j]!=0) {
						if(deq.isEmpty()) {
							deq.push(new Tile(board[i][j],false));
						}else {
							Tile t = deq.peek();
							if(!t.merged && t.number==board[i][j]) {
								deq.pop();
								t.number*=2;
								t.merged=true;
								deq.push(t);
							}else {
								deq.push(new Tile(board[i][j],false));
							}
						}
					}
				}
				int pos = n-1;
				while(!deq.isEmpty()) {
					board[i][pos--]=deq.pollLast().number;
				}
				for(int k=pos;k>=0;k--) {
					board[i][k]=0;
				}
			}
		}else if(direction==2) {
			for (int j = 0; j < n; j++) {
				for(int i=n-1;i>=0;i--) {
					if(board[i][j]!=0) {
						if(deq.isEmpty()) {
							deq.push(new Tile(board[i][j],false));
						}else {
							Tile t = deq.peek();
							if(!t.merged && t.number==board[i][j]) {
								deq.pop();
								t.number*=2;
								t.merged=true;
								deq.push(t);
							}else {
								deq.push(new Tile(board[i][j],false));
							}
						}
					}
				}
				int pos = n-1;
				while(!deq.isEmpty()) {
					board[pos--][j]=deq.pollLast().number;
				}
				for(int k=pos;k>=0;k--) {
					board[k][j]=0;
				}
			}
		}else { // if direction==3;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(board[i][j]!=0) {
						if(deq.isEmpty()) {
							deq.push(new Tile(board[i][j],false));
						}else {
							Tile t = deq.peek();
							if(!t.merged && t.number==board[i][j]) {
								deq.pop();
								t.number*=2;
								t.merged=true;
								deq.push(t);
							}else {
								deq.push(new Tile(board[i][j],false));
							}
						}
					}
				}
				int pos = 0;
				while(!deq.isEmpty()) {
					board[i][pos++]=deq.pollLast().number;
				}
				for(int k=pos;k<n;k++) {
					board[i][k]=0;
				}
			}
		}
	}

	private static int[][] copy(int[][] ori) {
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(ori[i], 0, arr[i], 0, n);
		}
		return arr;
	}

	private static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		// 내가 추가.
		if (c == 13)
			System.in.read(); // 윈도우때문에 -> 백준이 리눅스 기반으로 알고있음. 이거 필요없음.
		return n;
	}
	
	private static class Tile{
		int number;
		boolean merged;
		public Tile(int number, boolean merged) {
			this.number = number;
			this.merged = merged;
		}
	}
}
