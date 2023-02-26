package baekjoon.silver.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		// QUICK SORT
		new BJ_2751().quickSort(input, 0, n - 1);

		StringBuilder sb = new StringBuilder();
		for (int i : input) {
			sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}

	// 음수 해결 안됨
	int partition(int[] arr, int from, int to) {
		// 중간값 찾기 -> 안하면 시간초과
		int first = arr[from];
		int mid = arr[(from+to)/2];
		int last = arr[to];
		
		if(first < mid && mid < last || last < mid && mid < first) { // mid가 중간값
			swap(arr,from,(from+to)/2);
		}else if (mid < last && last < first || first < last && last < mid) { // last가 중간값
			swap(arr,from,to);
		}
		
		int pivot = arr[from];
		int bfrom = from;
		int bto = to;
		while (bfrom < bto) {
			// 오른쪽에 pivot 보다 작은 거 찾기.
			while (bfrom < bto && pivot < arr[bto]) {
				bto--;
			}
			// 왼쪽에 pivot보다 큰거 찾기
			while (bfrom < bto && pivot >= arr[bfrom]) {
				bfrom++;
			}
			if (bfrom > bto)
				break;

			// 자리바꾸기
			swap(arr, bfrom, bto);
		}
		swap(arr, from, bto);
		return bto;
	}

	void swap(int[] arr, int f, int t) {
		if (f != t) {
			arr[f] ^= arr[t];
			arr[t] ^= arr[f];
			arr[f] ^= arr[t];
		}
	}

	void quickSort(int[] arr, int from, int to) {
		if (from < to) {
			int pivot = partition(arr, from, to);
			quickSort(arr, from, pivot - 1);
			quickSort(arr, pivot + 1, to);
		}
	}
}
