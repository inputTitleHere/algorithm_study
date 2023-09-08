package swea.b특강;

import java.io.*;
import java.util.*;

public class Solution_19 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tcase; t++) {
			sb.append("#").append(t).append(" ");
			Map<String, Integer> map = new HashMap<>();
			String book = br.readLine();
			String word = br.readLine();

			for (int i = 0; i < book.length() - word.length()+1; i++) {
				String substr = book.substring(i, i + word.length());
				if (map.containsKey(substr)) {
					map.put(substr, map.get(substr) + 1);
				} else {
					map.put(substr, 1);
				}
			}
			sb.append(map.get(word)).append("\n");
		}
		System.out.println(sb.toString());

	}
}
