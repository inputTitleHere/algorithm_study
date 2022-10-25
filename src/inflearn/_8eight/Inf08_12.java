package inflearn._8eight;

import java.util.*;
public class Inf08_12 {
	
	static int n=0;
	static int m=0;
	static int zero = 0;
	static int[][] grid;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		grid=new int[n+2][m+2];
		for(int[] i : grid) {
			Arrays.fill(i, -1);
		}
		
		Queue<Point> q = new LinkedList<Point>();
		for(int i=1;i<=n;i++) {
			for (int j=1;j<=m;j++) {
				grid[i][j]=sc.nextInt();
				if(grid[i][j]==1) {
					q.offer(new Point(i,j));
				}else if(grid[i][j]==0) {
					zero++;
				}
			}
		}
		int step = 0;
//		for(int x=1;x<=n;x++) {
//			for (int y=1;y<=m;y++) {
//				if(grid[x][y]==1) {
//					if(grid[x-1][y]==0) {
//						q.add(new Point(x-1,y));
//					}
//					if(grid[x][y-1]==0) {
//						q.add(new Point(x, y-1));
//					}
//					if(grid[x+1][y]==0) {
//						q.add(new Point(x+1, y));
//					}
//					if(grid[x][y+1]==0) {
//						q.add(new Point(x, y+1));					
//					}
//				}
//			}
//		}
		
		while(!q.isEmpty()) {
			boolean flag = false;
			int len = q.size();
			for(int i=0;i<len;i++) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				grid[x][y]=step;
				if(grid[x-1][y]==0) {
					grid[x-1][y]=step+1;
					flag=true;
					zero--;
					q.add(new Point(x-1,y));
				}
				if(grid[x][y-1]==0) {
					grid[x][y-1]=step+1;
					flag=true;
					zero--;
					q.add(new Point(x, y-1));
				}
				if(grid[x+1][y]==0) {
					grid[x+1][y] = step+1;
					flag=true;
					zero--;
					q.add(new Point(x+1, y));
				}
				if(grid[x][y+1]==0) {
					grid[x][y+1]=step+1;
					flag=true;
					zero--;
					q.add(new Point(x, y+1));					
				}
			}
			if(flag) step++;
		}
		if(zero>0) {
			System.out.println(-1);
		}else {
			System.out.println(step);			
		}
	}
}
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
