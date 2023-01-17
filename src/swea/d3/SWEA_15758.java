package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_15758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int tcase = 1; tcase <= tc; tcase++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			String s = stk.nextToken();
			String t = stk.nextToken();
			// 앞과 뒤로만 확인하면 될듯?
			// 길이판별
			if (s.length() < t.length()) { // t가 긴경우만 변경
				String temp = s;
				s = t;
				t = temp;
			}
			boolean flag = true;
			char[] schar = s.toCharArray();
			char[] tchar = t.toCharArray();

			for (int i = 0; i < tchar.length; i++) {
				if (schar[i] != tchar[i] || tchar[i] != schar[schar.length - tchar.length + i]) {
					flag = false;
					break;
				}
			}
			// 케이스 xzxxz xz나 xzxxxz xz같은 경우
			if (schar.length > tchar.length * 2) {
				int offset = 0;
				OFFSET: while (offset+tchar.length < schar.length) {
					for (int i = 0; i < tchar.length; i++) {
						if (schar[offset + i] != tchar[i]) {
							flag = false;
							break OFFSET;
						}
					}
					offset += tchar.length;
				}
			}
			System.out.printf("#%d %s\n", tcase, flag ? "yes" : "no");
		}
	}
}
