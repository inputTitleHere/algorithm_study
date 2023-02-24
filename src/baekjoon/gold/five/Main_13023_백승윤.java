package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// java 11 : 272ms
// Java  8 : 236ms
public class Main_13023_백승윤 {

	static List<ArrayList<Integer>> rel;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken()); // number of people
		m = Integer.parseInt(stk.nextToken()); // number of relations.

		rel = new ArrayList<>(n);
		for(int i=0;i<n;i++) {
			rel.add(new ArrayList<>());
		}
		// load data
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			// friends are non-directional
			rel.get(from).add(to);
			rel.get(to).add(from);
		}

		int res = 0;
		boolean[] fl = new boolean[n];		
		for (int i = 0; i < n; i++) {
			fl[i]=true;
			if (dfs(i, fl, 1)) {
				res = 1;
				break;
			}
			fl[i]=false;
		}
		System.out.println(res);

	}

	private static boolean dfs(int curr, boolean[] fl, int step) {
		if (step == 5) {
			return true;
		}

		for (int f : rel.get(curr)) {
			if (!fl[f]) {
				fl[f]=true;
				if(dfs(f,fl,step+1)) {
					return true;
				}
				fl[f]=false;
			}
		}
		return false;
	}
}
