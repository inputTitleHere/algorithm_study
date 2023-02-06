package baekjoon.silver.one;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ_1914 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 일단 이동 총횟수 연산
		BigInteger bi = new BigInteger("2").pow(n).subtract(BigInteger.ONE); 
		
//		long moves = (1L << n) - 1; // 이동횟수
		sb.append(bi).append("\n");
		// 진짜 어려운건 이동 시뮬
		if (n <= 20) {
			int[] orders = order(1, n, 0, new int[bi.intValue()]);
			int[] pos = new int[n + 1];
			if (n % 2 == 0) { // 길이 짝수
				for (int toMove : orders) {
					if (toMove % 2 == 1) { // 홀수번 원판은 오른쪽으로 이동
						sb.append(pos[toMove] + 1).append(" ");
						pos[toMove] = pos[toMove] == 2 ? 0 : pos[toMove] + 1;
						sb.append(pos[toMove] + 1).append("\n");
					} else {
						sb.append(pos[toMove] + 1).append(" ");
						pos[toMove] = pos[toMove] == 0 ? 2 : pos[toMove] - 1;
						sb.append(pos[toMove] + 1).append("\n");
					}
				}
			} else { // 길히 홀수
				for (int toMove : orders) {
					if (toMove % 2 == 1) { // 홀수번 원판은 오른쪽으로 이동
						sb.append(pos[toMove] + 1).append(" ");
						pos[toMove] = pos[toMove] == 0 ? 2 : pos[toMove] - 1;
						sb.append(pos[toMove] + 1).append("\n");
					} else {
						sb.append(pos[toMove] + 1).append(" ");
						pos[toMove] = pos[toMove] == 2 ? 0 : pos[toMove] + 1;
						sb.append(pos[toMove] + 1).append("\n");
					}
				}
			}
		}
		System.out.print(sb.toString());
		sc.close();
	}

	static int[] order(int step, int max, int ptr, int[] list) {
		if(step>max) return list;
		list[ptr]=step;
		System.arraycopy(list, 0, list, ptr+1, ptr);
		ptr=ptr*2+1;
		return order(step+1, max, ptr,list); 
	}
}
