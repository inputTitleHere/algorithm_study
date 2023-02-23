package baekjoon.silver.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_백승윤 {

	static boolean[][] matrix;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static int v;
	static int e;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		v = Integer.parseInt(stk.nextToken());
		e = Integer.parseInt(stk.nextToken());
		int start = Integer.parseInt(stk.nextToken());

		// 두정점 사이에 여러개의 간선이 있을 수 있다. -> 인접리스트 말고 matrix를 사용하겠다.
		boolean[][] tmp = new boolean[v + 1][v + 1]; // 임시 배열(속도향상은 몰?루)
		for (int i = 0; i < e; i++) { // 간선 정보 로딩하기
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			tmp[from][to] = true;
			tmp[to][from] = true;
		}
		// 데이터 배치
		matrix = tmp;
		visited = new boolean[v + 1];

		// DFS 실행
		dfs(start);
		sb.append("\n");
		// BFS 실행
		bfs(start);
		// 결과 출력
		System.out.println(sb.toString());
	}

	private static void dfs(int from) {
		sb.append(from).append(" ");
		visited[from] = true;
		for (int i = 1; i <= v; i++) {
			if (matrix[from][i] && !visited[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int start) {
		visited = new boolean[v + 1]; // 초기화
		Queue<Integer> que = new ArrayDeque<>();
		visited[start] = true;
		que.add(start);
		while (!que.isEmpty()) {
			int next = que.poll();
			sb.append(next).append(" ");
			for (int i = 1; i <= v; i++) {
				if (matrix[next][i] && !visited[i]) {
					visited[i] = true;
					que.add(i);
				}
			}
		}
	}
}
