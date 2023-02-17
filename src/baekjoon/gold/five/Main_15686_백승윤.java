package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_백승윤 {
	static int globalMin = Integer.MAX_VALUE;
	static List<int[]> house;
	static List<int[]> chicken;
	static boolean[] using;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// r 행 - c 열
		// 1부터 시작. -> 거리는 맨하탄 거리.
		// 0 빈칸, 1집, 2치킨!!!! 배고프다.
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		house = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < n; i++) { // 집하고 치킨집 정보만 저장.
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int next = Integer.parseInt(stk.nextToken());
				if (next == 0)
					continue;
				if (next == 1)
					house.add(new int[] { i, j });
				else
					chicken.add(new int[] { i, j });
			}
		}
		
		using = new boolean[chicken.size()];
		
		dfs(0,0);
		
		System.out.println(globalMin);
	}
	static void dfs(int step, int count) {
		if(count==m) {
			int sum=0;
			for(int i=0;i<house.size();i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0;j<chicken.size();j++) {
					if(using[j]) {
						int dist = distance(house.get(i),chicken.get(j));
						min = Math.min(min, dist);
					}
				}
				sum+=min;
				if(sum>=globalMin) {
					return;
				}
			}
			globalMin = Math.min(sum, globalMin);
			return;
		}
		if(step==chicken.size()) {
			return;
		}
		using[step]=true;
		dfs(step+1, count+1);
		using[step]=false;
		dfs(step+1,count);
		
	}
	static int distance(int[] a, int[] b) {
		return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
	}
}
