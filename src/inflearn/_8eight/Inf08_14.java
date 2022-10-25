package inflearn._8eight;

import java.util.*;

public class Inf08_14 {
	static int n;
	static int m;
	static int[] comb;
	static ArrayList<Point> house,pizza;
	static int answer = Integer.MAX_VALUE;
	static int length;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		house = new ArrayList<Point>();
		pizza = new ArrayList<Point>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int input = sc.nextInt();
				if(input==1) house.add(new Point(i,j));
				else if(input == 2) pizza.add(new Point(i,j));
			}
		}
		length = pizza.size();
		comb = new int[m]; // 뽑을거
		dfs(0,0);
		System.out.println(answer);
	}
	static void dfs(int curr, int s) { // curr = 몇번째, s = 값
		if(curr==m) { // 조합 개수가 맞음
			// 거리 판단.
			int sum = 0;
			for(Point h : house) {
				int distance = Integer.MAX_VALUE;
				for(int i : comb) { // 사용할 인덱스번호(살아남을 피자집 다 비교)
					distance=Math.min(distance, Math.abs(h.x-pizza.get(i).x)+Math.abs(h.y-pizza.get(i).y));
				}
				// 최소 distance 거리가 나왔을 것이다. -> 이 집의 피자배달거리
				sum+=distance; // 도시의 피자배달거리 누적.
			}
			answer = Math.min(sum, answer);
		}else {
			for(int i=s;i<length;i++) {
				comb[curr]=i;
				dfs(curr+1, i+1);
			}
		}
	}
	
	

	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
}
