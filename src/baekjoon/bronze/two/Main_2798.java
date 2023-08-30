package baekjoon.bronze.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2798 {

	static int sum = 0;
	static int max = 0;
	static int m;
	static int n;
	static int[] cards;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int idxptr = 0;
		n = Integer.parseInt(line.substring(0, (idxptr = line.indexOf(' '))));
		m = Integer.parseInt(line.substring(idxptr + 1));

		cards = new int[n];
		int ptr = 0;
		line = br.readLine();
		int prevPtr = idxptr = 0;
		while ((idxptr = line.indexOf(' ', idxptr + 1)) != -1) {
			cards[ptr++] = Integer.parseInt(line.substring(prevPtr, idxptr));
			prevPtr = idxptr + 1;
		}
		cards[ptr] = Integer.parseInt(line.substring(prevPtr));

		Arrays.sort(cards);
		blackjack(0, 0);
		System.out.println(max);

	}

	static void blackjack(int step, int current) {
		if (step == 3) {
			// check if over or under?
			if (sum <= m && sum > max) {
				max = sum;
			}
			return;
		}
		for (int i = current; i < n; i++) {
			sum += cards[i];
			if (sum > m) {
				sum -= cards[i];
				return;
			}
			blackjack(step + 1, i + 1);
			sum -= cards[i];
		}
	}
}
