package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// java 11 : 756ms
public class Main_1753_백승윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(stk.nextToken());
		int e = Integer.parseInt(stk.nextToken());

		int start = Integer.parseInt(br.readLine());
		// u -> v weight w
		// 인접행렬 쓰면 메모리 초과날 것.
		ArrayList<int[]>[] mtrx = new ArrayList[v + 1];
		for (int i = 0; i < v + 1; i++) {
			mtrx[i] = new ArrayList<>();
		}
		// 데이터 로딩
		for (int i = 0; i < e; i++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int weight = Integer.parseInt(stk.nextToken());

			mtrx[from].add(new int[] { to, weight });
		} // END DATA LOAD

		// Dijk Setting
		boolean[] visited = new boolean[v + 1];
		int[] distance = new int[v + 1];
		final int INF = 9999999;
		fastFill(distance, INF);

		// {to, weight} 으로 저장할 것. -> start -> v의 전체 weight으로 비교할것(오름차순)
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] arr1, int[] arr2) -> {
			return arr1[1] - arr2[1];
		});
		// 초기 세팅
		distance[start] = 0; // 방문처리
		for (int[] iarr : mtrx[start]) {
			distance[iarr[0]] = Math.min(iarr[1],distance[iarr[0]]);
			pq.add(new int[] {iarr[0], iarr[1]}); // to, weight
		}
		visited[start] = true;
		
		int current = start;
		for (int points = 0; points < v; points++) { // 정점개수만큼
			if(pq.isEmpty()) break;
			int[] curr = pq.poll();
			current = curr[0];
			
			if(visited[current]) {
				points--;
				continue;
			}
			visited[current]=true;
			
			for (int[] iarr : mtrx[current]) {
				if (distance[iarr[0]] > curr[1] + iarr[1]) {
					distance[iarr[0]] = curr[1]+iarr[1];
					pq.add(new int[] { iarr[0], distance[iarr[0]]});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	// 2배씩 늘리며 채우기
	static void fastFill(int[] arr, int with) {
		int n;
		if (arr == null || (n = arr.length) == 0) {
			return;
		}
		arr[0] = with;
		int i = 1;
		while (i < n) {
			System.arraycopy(arr, 0, arr, i, i * 2 < n ? i : n - i);
			i += i;
		}
	}
}
