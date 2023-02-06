package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		// 메모리 길이 1~50
		int[] zeros = new int[50];
		int[] ones = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
//			int[] input = br.readLine().chars().map((i) -> i - '0').toArray();
			char[] input = br.readLine().toCharArray();
			// 초기화에서 시작됨
			int[] fixed = new int[input.length];
			int count = 0;
			for (int i = 0; i < input.length; i++) {
				if (fixed[i] != input[i]-'0') {
					count++;
					if (fixed[i] == 0) { // 1로 뒤집기
						System.arraycopy(ones, i, fixed, i, input.length - i);
					} else {
						System.arraycopy(zeros, i, fixed, i, input.length - i);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}

// (SWEA)Solution_문제번호_자기이름
// (백준)Main_문제번호_자기이름
