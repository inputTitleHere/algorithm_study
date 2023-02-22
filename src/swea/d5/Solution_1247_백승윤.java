package swea.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 625ms
public class Solution_1247_백승윤 {
	static StringBuilder sb = new StringBuilder();
	static int[][] look;
	static boolean[] visited;
	static int globalMin;
	static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			n = Integer.parseInt(br.readLine());
			int[][] table = new int[n+2][2];
			visited = new boolean[n+2];
			stk = new StringTokenizer(br.readLine());
			// 0은 회사, 1은 집 2~n+1까지 고객들
			for(int i=0;i<n+2;i++) {
				table[i][0]=Integer.parseInt(stk.nextToken());
				table[i][1]=Integer.parseInt(stk.nextToken());
			}
			look = new int[n+2][n+2];
			globalMin=Integer.MAX_VALUE;
			for(int i=0;i<n+2;i++) {
				for(int j=0;j<n+2;j++) {
					if(i==j) continue;
					look[i][j]=look[j][i]=Math.abs(table[i][0]-table[j][0]) + Math.abs(table[i][1]-table[j][1]);
				}
			}
			int[] order = new int[n];
			for(int i=2;i<n+2;i++) {
				order[i-2]=i;
			}
			
			int sum=0;
			do {
				sum=0;
				// 처음 회사에서
				sum+=look[0][order[0]];
				// 고객들 끼리
				for(int i=0;i<n-1;i++) {
					sum+=look[order[i]][order[i+1]];
				}
				// 집가기
				sum+=look[order[n-1]][1];
				globalMin = Math.min(sum, globalMin);
			}while(nextPermutation(order));			
			sb.append(globalMin).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static boolean nextPermutation(int[] order) {
		int i=n-1; // 끝
		while(i>0 && order[i-1] > order[i]) { // 처음 꺽이는 값을 뒤에서 찾기.
			i--;
		}
		if(i==0) return false; // 완전 역순 정렬되어있으면 끝임.
		int j=n-1; // 끝 포인터
		while(order[i-1] > order[j]) j--; // 기준보다 큰 값 탐색
		swap(i-1,j,order);
		
		int tmp = n-1;
		while(i<tmp) swap(i++, tmp--,order);
		
		return true;
	}
	private static void swap(int from, int to, int[] arr) {
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to]=tmp;
	}
	
//	private static void search(int step, int prev, int distSum) { // nextpermutation 그거 써보기
//		if(step==n) {
//			// 집가기
//			distSum+=look[prev][1];
//			globalMin=Math.min(distSum, globalMin);
//			return;
//		}
//		for(int i=2;i<n+2;i++) {
//			if(visited[i]) continue;
//			visited[i]=true;
//			search(step+1,i,distSum+look[prev][i]);
//			visited[i]=false;
//		}
//	}
}
