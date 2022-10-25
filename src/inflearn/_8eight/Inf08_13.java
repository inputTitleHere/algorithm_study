package inflearn._8eight;

import java.util.*;
public class Inf08_13 {
	
	static int n;
	static int[][] map;
	static int[][] checked;
	static int counter =0;
	/*
	 *   7 8 9
	 *   4   6
	 *   1 2 3
	 */
	static int[] xmap = {-1, 0, 1,-1, 1,-1, 0, 1};
	static int[] ymap = { 1, 1, 1, 0, 0,-1,-1,-1};
	
	static Queue<Point> q = new LinkedList<Point>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		// -- 채우기 끝 -- //
		checked = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				check(i,j);
			}
		}
		
		System.out.println(counter);
	}
	static void check(int x, int y) {
		if(checked[x][y]==2 || map[x][y]==0) return;
		counter++;
		q.add(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int cx = p.x;
			int cy = p.y;
			// 8 방향
			for(int k=0;k<8;k++) {
				int nx = cx+xmap[k];
				int ny = cy+ymap[k];
				// 틀 안에 있을 때
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(checked[nx][ny]!=2 && map[nx][ny]==1) {
						checked[nx][ny]=2;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
		
		
	}
	// 패키지의 다른 Point랑 겹쳐서 내부클래스 static 했음.
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return String.format("[%d,%d]", x,y);
		}
		
	}
}

