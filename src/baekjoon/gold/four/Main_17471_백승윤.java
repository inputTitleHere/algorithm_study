package baekjoon.gold.four;

import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;


// Java 11 : 140ms
// Java  8 : 96ms
public class Main_17471_백승윤 {

	static int n;
	static int[] population;
	static int[][] map;

	static int[] leftSelect;
	static int[] rightSelect;
	static int gMinDif;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		n = Integer.parseInt(br.readLine());
		gMinDif = Integer.MAX_VALUE;
		population = new int[n + 1];
		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) { // 인구 데이터 로딩
			population[i] = Integer.parseInt(stk.nextToken());
		}
		map = new int[n + 1][]; // 관계도 맵로딩
		for (int i = 1; i < n + 1; i++) {
			stk = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(stk.nextToken());
			map[i] = new int[size];
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
//		for(int[] iarr : map) {
//			System.out.println(Arrays.toString(iarr));
//		}
		
		leftSelect = new int[n];
		rightSelect = new int[n];
		powerset(1, 0, 0);
		if (gMinDif == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(gMinDif);
		}

	}

	// 1부터 시작
	static void powerset(int step, int left, int right) {
		if (step == n + 1) {
			// 한쪽 진영이 아예 없는 건 안됨.
			if (left == 0 || right == 0) {
				return;
			}

			// valid한 영역인지 확인
			// 기본적으로 선택영역들은 정렬되어있는 상태일 것.
			Queue<Integer> que = new ArrayDeque<Integer>();
			boolean[] visited = new boolean[n + 1];
			visited[leftSelect[0]] = true;
			que.add(leftSelect[0]);
			while (!que.isEmpty()) {
				int next = que.poll();
				for (int i : map[next]) {
					if (!visited[i] && includes(leftSelect, i, 0, left)) {
						visited[i] = true;
						que.add(i);
					}
				}
			}
			for (int i = 0; i < left; i++) {
				if (!visited[leftSelect[i]]) {
					return;
				}
			}
			// 오른쪽
			que = new ArrayDeque<Integer>();
			visited = new boolean[n + 1];
			visited[rightSelect[0]] = true;
			que.add(rightSelect[0]);
			while (!que.isEmpty()) {
				int next = que.poll();
				for (int i : map[next]) {
					if (!visited[i] && includes(rightSelect, i, 0, right)) {
						visited[i] = true;
						que.add(i);
					}
				}
			}
			for (int i = 0; i < right; i++) {
				if (!visited[rightSelect[i]]) {
					return;
				}
			}

			// 차이 구하기
			int lsum = 0;
			for (int i = 0; i < left; i++) {
				lsum += population[leftSelect[i]];
			}
			int rsum = 0;
			for (int i = 0; i < right; i++) {
				rsum += population[rightSelect[i]];
			}
			gMinDif = Math.min(gMinDif, Math.abs(lsum - rsum));

			return;
		}

		// 왼쪽에 넣기
		leftSelect[left] = step;
		powerset(step + 1, left + 1, right);
		leftSelect[left] = 0;
		// 오른쪽에 넣기
		rightSelect[right] = step;
		powerset(step + 1, left, right + 1);
		rightSelect[right] = 0;

	}

	static boolean includes(int[] arr, int target, int from, int to) {
		int mid = (from + to) / 2;
		if (to < from) {
			return false;
		}
		if (target == arr[mid]) {
			return true;
		} else if (target < arr[mid]) {
			return includes(arr, target, from, mid - 1);
		} else {
			return includes(arr, target, mid + 1, to);
		}
	}
}
