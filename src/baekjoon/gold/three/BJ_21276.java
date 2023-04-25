package baekjoon.gold.three;

import java.io.*;
import java.util.*;

public class BJ_21276 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(br.readLine());

		Map<String, List<String>> relation = new HashMap<>();
		Map<String, Set<String>> lineage = new TreeMap<>();
		Map<String, Integer> ancestors = new HashMap<>();
		List<String> root = new ArrayList<>();

		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < p; i++) {
			String next = stk.nextToken();
			relation.put(next, new ArrayList<>());
			lineage.put(next, new TreeSet<>());
			ancestors.put(next, 0);
		}

		// 역방향으로 기록 x->y (x has ancestor y)
		// ancestor -> descendant
		int e = Integer.parseInt(br.readLine());
		for (int i = 0; i < e; i++) {
			stk = new StringTokenizer(br.readLine());
			String des = stk.nextToken();
			String anc = stk.nextToken();
			relation.get(anc).add(des);
			ancestors.put(des, ancestors.get(des) + 1);
		}
		// find entry point

		Queue<String> que = new ArrayDeque<>();
		for (String s : ancestors.keySet()) {
			int count = ancestors.get(s);
			if (count == 0) { // is root
				root.add(s);
				que.add(s);
			}
		}
		Collections.sort(root);

		while (!que.isEmpty()) {
			String next = que.poll();
			for (String s : relation.get(next)) {
				int count = ancestors.get(s);
				ancestors.put(s, count - 1);
				if (count == 1) { // 마지막이였으면
//					System.out.printf("%s's child is %s\n",next,s);
					lineage.get(next).add(s);
					que.add(s);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(root.size()).append("\n");
		for (String s : root) {
			sb.append(s).append(" ");
		}
		sb.append("\n");

		for(String s : lineage.keySet()) {
			Set<String> child = lineage.get(s);
			sb.append(s).append(" ").append(child.size()).append(" ");
			for(String ch : child) {
				sb.append(ch).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
