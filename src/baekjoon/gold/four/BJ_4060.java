package baekjoon.gold.four;

import java.io.*;
import java.util.*;

public class BJ_4060 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNo = 1;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		while (n != 0) {
			int letters = n;
			int sum = 0;
			StringTokenizer stk = new StringTokenizer(br.readLine());
			while (letters != 0) {
				if (!stk.hasMoreTokens()) {
					stk = new StringTokenizer(br.readLine());
				}
				String s = stk.nextToken();
				sum += convertRomanToArabicNumber(s);
				letters--;
			}
			sb.append("Case ").append(convertArabicToRomanNumber(caseNo++)).append(": ")
					.append(convertArabicToRomanNumber(sum)).append("\n");

			n = Integer.parseInt(br.readLine());
		}
		System.out.println(sb.toString());
	}

	static int convertRomanToArabicNumber(String s) {
		int sum = 0;
		int pointer = 0;
		int len = s.length();
		while (pointer < len) {
			char c = s.charAt(pointer);
			switch (c) {
			case 'I':
				if (pointer < len - 1) {
					char next = s.charAt(pointer + 1);
					if (next == 'X') {
						pointer++;
						sum += 9;
					} else if (next == 'V') {
						pointer++;
						sum += 4;
					} else {
						sum++;
					}
				} else {
					sum += 1;
				}
				break;
			case 'V':
				sum += 5;
				break;
			case 'X':
				if (pointer < len - 1) {
					char next = s.charAt(pointer + 1);
					if (next == 'C') {
						pointer++;
						sum += 90;
					} else if (next == 'L') {
						pointer++;
						sum += 40;
					} else {
						sum += 10;
					}
				} else {
					sum += 10;
				}
				break;
			case 'L':
				sum += 50;
				break;
			case 'C':
				if (pointer < len - 1) {
					char next = s.charAt(pointer + 1);
					if (next == 'M') {
						pointer++;
						sum += 900;
					} else if (next == 'D') {
						pointer++;
						sum += 400;
					} else {
						sum += 100;
					}
				} else {
					sum += 100;
				}
				break;
			case 'D':
				sum += 500;
				break;
			case 'M':
				sum += 1000;
				break;
			}
			pointer++;
		}
		return sum;
	}

	static String convertArabicToRomanNumber(int n) {
		StringBuilder sb = new StringBuilder();
		int M = n / 1000;
		n %= 1000;
		for (int i = 0; i < M; i++) {
			sb.append('M');
		}

		int C = n / 100;
		n %= 100;
		sb.append(buildRomanDecimal(C, 'C', 'D', 'M'));
		int X = n / 10;
		n %= 10;
		sb.append(buildRomanDecimal(X, 'X', 'L', 'C'));

		int I = n;
		sb.append(buildRomanDecimal(I, 'I', 'V', 'X'));

		return sb.toString();
	}

	static String buildRomanDecimal(int n, char one, char five, char ten) {
		StringBuilder sb = new StringBuilder();
		switch (n) {
		case 9:
			sb.append(one).append(ten);
			break;
		case 8:
			sb.append(five).append(one).append(one).append(one);
			break;
		case 7:
			sb.append(five).append(one).append(one);
			break;
		case 6:
			sb.append(five).append(one);
			break;
		case 5:
			sb.append(five);
			break;
		case 4:
			sb.append(one).append(five);
			break;
		case 3:
			sb.append(one).append(one).append(one);
			break;
		case 2:
			sb.append(one).append(one);
			break;
		case 1:
			sb.append(one);
			break;
		case 0:
			break;
		}
		return sb.toString();
	}

}
