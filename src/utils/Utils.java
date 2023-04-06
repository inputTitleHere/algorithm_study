package utils;

import java.io.IOException;

public class Utils {
	
	/**
	 * 빠른 숫자입력 Default 
	 * Window에서 사용가능하도록 c==13 체크 추가.
	 * @return
	 * @throws IOException
	 */
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		// 내가 추가.
		if (c == 13)
			System.in.read(); // 윈도우때문에 -> 백준이 리눅스 기반으로 알고있음. 이거 필요없음.
		return n;
	}
	
	
	/**
	 * 빠른 배열 채우기 -> log2n?
	 * @param arr
	 * @param with
	 * @return
	 */
	static int[] fastFill(int[] arr, int with) {
		int len = arr.length;
		arr[0] = with;

		int ptr = 1;
		while (ptr < len) {
			System.arraycopy(arr, 0, arr, ptr, ptr << 1 < len ? ptr : len - ptr);
			ptr <<= 1;
		}
		return arr;
	}
}
