package swea.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_TestSample_1767 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static List<int[]> cpuList;
	static int[][] circuit;
	static int n;
	static int minlen;
	static int maxconn;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		// 1~4방향 + 아예 연결 안하는 경우
		int tc = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			n = Integer.parseInt(br.readLine());
			maxconn=0;
			minlen = Integer.MAX_VALUE;
			cpuList = new ArrayList<int[]>(12);
			circuit = new int[n][n];
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int next = Integer.parseInt(stk.nextToken());
					circuit[i][j] = next;
					if (next == 1 && (i != 0 && i != n - 1) && (j != 0 && j != n - 1)) {
						cpuList.add(new int[] { i, j }); // y,x
					}
				}
			}
//			for(int[] i : cpuList) {
//				System.out.println(Arrays.toString(i));
//			}
			dfs(0,0,0);
			sb.append(minlen).append("\n");
		} // ++++++++++++++++++++
		System.out.println(sb.toString());
	}

	static void dfs(int step, int connected, int len) {
//		System.out.printf("connected : %d len : %d\n",connected,len);
		if(step==cpuList.size()) {
			if(connected>maxconn) {
				maxconn=connected;
				minlen=len;
			}else if (connected == maxconn) {
				minlen=Math.min(minlen, len);				
			}
			// 연결 cpu가 적으면 안함.
			return;
		}
		
		
		int[] cpu = cpuList.get(step);
		for(int i=0;i<4;i++) { // 어디론가 연결하는 케이스
			int ny = cpu[0]+dir[i][0];
			int nx = cpu[1]+dir[i][1];
			boolean flag=true;
			while(ny>-1 && ny<n && nx>-1 && nx<n) {
				if(circuit[ny][nx] !=0) {
					flag=false;
					break;
				}
				ny+=dir[i][0];
				nx+=dir[i][1];
			}
			if(flag) { // 연결가능하면 전선 배치하기
				int locallen=0;
				ny = cpu[0]+dir[i][0];
				nx = cpu[1]+dir[i][1];
				while(ny>-1 && ny<n && nx>-1 && nx<n) {
					locallen++;
					circuit[ny][nx]=9;
					ny+=dir[i][0];
					nx+=dir[i][1];
				}
//				System.out.println("==============================");
//				for(int zxc=0;zxc<n;zxc++) {
//					System.out.println(Arrays.toString(circuit[zxc]));
//				}
				// dfs
				dfs(step+1,connected+1,len+locallen);
				
				// 원복
				ny = cpu[0]+dir[i][0];
				nx = cpu[1]+dir[i][1];
				while(ny>-1 && ny<n && nx>-1 && nx<n) {
					circuit[ny][nx]=0;
					ny+=dir[i][0];
					nx+=dir[i][1];
				}
			}
			// 연결 못하면 가지치기
		}
		// 연결 안하는 케이스
		dfs(step+1,connected,len);
	}
}
