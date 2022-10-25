package inflearn._8eight;

import java.util.*;
public class Inf08_11 {
	
	static int[][] map = new int[9][9];
	static int min = 999;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int[] arr : map) {
			Arrays.fill(arr, 1);
		}
		
		for(int i=1;i<8;i++) {
			for(int j=1;j<8;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 슥삭해온 deep copy
		int[][] breadCrumb = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
		solve(1,1,breadCrumb,0);
		System.out.println(min==999?-1:min);
	}
	static void solve(int x, int y,int[][] breadCrumb, int len){
//		printMap(breadCrumb);
//		try {
//			Thread.sleep(500);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		if(x==7&&y==7) {
			if(len<min) {
				min=len;
			}
			return;
		}
		breadCrumb[x][y]=2;
		if(breadCrumb[x+1][y]==0) {
			int[][] copy = Arrays.stream(breadCrumb).map(int[]::clone).toArray(int[][]::new);
			solve(x+1,y,copy,len+1);
		}
		if(breadCrumb[x][y+1]==0) {
			int[][] copy = Arrays.stream(breadCrumb).map(int[]::clone).toArray(int[][]::new);
			solve(x,y+1,copy,len+1);
		}
		if(breadCrumb[x-1][y]==0) {
			int[][] copy = Arrays.stream(breadCrumb).map(int[]::clone).toArray(int[][]::new);
			solve(x-1,y,copy,len+1);
		}
		if(breadCrumb[x][y-1]==0) {
			int[][] copy = Arrays.stream(breadCrumb).map(int[]::clone).toArray(int[][]::new);
			solve(x,y-1,copy,len+1);
		}
		
	}
	static void printMap(int[][] map) {
		System.out.println("===========================");
		for(int[] arr : map) {
			for(int i:arr) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}
}
