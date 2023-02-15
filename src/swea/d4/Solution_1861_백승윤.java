package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// DFS -> 159ms
public class Solution_1861_백승윤 {

	static int n;
	static int[][] board;
	static int[][] visited;
	static StringBuilder sb;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n][n];
			visited = new int[n][n];
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(stk.nextToken());
				}
			}

			int minNo = Integer.MAX_VALUE;
			int maxLen = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] != 0) {
						continue;
					}
					int moves = dfs(i,j);
					if(moves>maxLen) {
						minNo = board[i][j];
						maxLen = moves;
					}
					if(moves==maxLen) {
						minNo = Math.min(minNo, board[i][j]);
					}
				}
			}
			sb.append("#").append(t).append(" ").append(minNo).append(" ").append(maxLen).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int dfs(int ip, int jp) {
		for(int k=0;k<4;k++) {
			int ni = ip+dy[k];
			int nj = jp+dx[k];
			if(ni<n && ni>-1 && nj<n && nj>-1 && board[ip][jp]+1==board[ni][nj]) {
				visited[ip][jp] = dfs(ni,nj)+1;
				return visited[ip][jp];
			}
		}
		visited[ip][jp]=1;
		return 1;
	}
}
