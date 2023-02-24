package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ_14226 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(br.readLine());
		int[] vis = new int[s * 2];
		fillMax(vis);

		Queue<Step> que = new ArrayDeque<>();
		que.add(new Step(1, 0, false, 0));
		vis[1] = 0;
		while (!que.isEmpty()) {
			Step step = que.poll();
			if (step.len == s) {
				System.out.println(step.step);
				return;
			}
			if (!step.didCopy) {
				Step newStep = new Step(step.len, step.len, true, step.step + 1);
				que.add(newStep);
			}
			// 붙여넣기
			if (step.copy != 0) {
				int next = step.len + step.copy;
				if (next < vis.length && step.step + 1 <= vis[next]) {
					vis[next] = step.step + 1;
				}
				Step newStep = new Step(step.len + step.copy, step.copy, false, step.step + 1);
				que.add(newStep);
			}
			// 빼기
			if (step.len > 0) {
				int next = step.len - 1;
				if (next < vis.length && step.step + 1 <= vis[next]) {
					Step newStep = new Step(step.len - 1, step.copy, false, step.step + 1);
					que.add(newStep);
				}
			}
		}
	}

	private static void fillMax(int[] arr) {
		arr[0] = Integer.MAX_VALUE;
		int ptr = 1;
		while (ptr < arr.length) {
			int move = ptr * 2 < arr.length ? ptr : (arr.length - ptr);
			System.arraycopy(arr, 0, arr, ptr, move);
			ptr += move;
		}
	}

	private static class Step {
		int len;
		int copy;
		boolean didCopy;
		int step;

		public Step(int len, int copy, boolean didCopy, int step) {
			this.len = len;
			this.copy = copy;
			this.didCopy = didCopy;
			this.step = step;
		}
	}
}
