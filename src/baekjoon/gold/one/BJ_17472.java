package baekjoon.gold.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// Java 11 : 136ms
public class BJ_17472 {
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 다리는 무조건 길이 2 이상.
		// 다리는 방향이 바뀌면 안된다. -> 무조건 가로 OR 세로방향
		// 다리가 교차하는 건 가능 -> 길이는 두번 세야함.
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken()); // 세로
		int m = Integer.parseInt(stk.nextToken()); // 가로

		int[][] localMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				localMap[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		// 섬 개수 파악하기 -> map 순회하면서 1 만나면 bfs으로 10, 11, ... 으로 변경.
		// 각 섬에서 갈 수 있는 다른 섬 파악하기 -> 섬에 대한 인접행렬 생성 각 섬 구획마다 bfs으로 탐색
		// 생성한 인접행렬을 이용해 MST 생성 -> 프림 써보기?

		// 연결 안된것 있으면 -1 반환.
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //

		// 섬 개수 파악하기 -> map 순회하면서 1 만나면 bfs으로 10, 11, ... 으로 변경.
		int island = 0;

		Queue<int[]> que = new ArrayDeque<int[]>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (localMap[i][j] == 1) {
					// BFS으로 섬 파악
					int offset = island + 10; // 섬은 10번부터 최대 16번까지.
					que.add(new int[] { i, j });
					while (!que.isEmpty()) {
						int[] next = que.poll();
						localMap[next[0]][next[1]] = offset;
						for (int z = 0; z < 4; z++) {
							int ny = next[0] + dir[z][0];
							int nx = next[1] + dir[z][1];
							if (ny > -1 && ny < n && nx > -1 && nx < m && localMap[ny][nx] == 1) {
								que.add(new int[] { ny, nx });
							}
						}
					}
					island++; // 섬 발견 추가.
				}
			}
		}

		// 각 섬에서 갈 수 있는 다른 섬 파악하기 -> 섬에 대한 인접행렬 생성 각 섬 구획마다 bfs으로 탐색
		int[][] matrix = new int[island][island];
		// INIT matrix to max;
		Arrays.fill(matrix[0], Integer.MAX_VALUE);
		for (int i = 1; i < island; i++) {
			System.arraycopy(matrix[0], 0, matrix[i], 0, island);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (localMap[i][j] != 0) {
					int isle = localMap[i][j];
					int ori = isle - 10;
					for(int z=0;z<4;z++) {
						int step=0;
						int ny=i+dir[z][0];
						int nx=j+dir[z][1];
						while(ny>-1 && ny<n && nx>-1 && nx<m && localMap[ny][nx]!=isle) {
							if(localMap[ny][nx]!=0) {
								if(step<2) {
									break;
								}
								int no = localMap[ny][nx]-10;
								matrix[ori][no] = Math.min(step, matrix[ori][no]);
								matrix[no][ori] = Math.min(step, matrix[no][ori]);
								break;
							}
							step++;
							ny+=dir[z][0];
							nx+=dir[z][1];
						}
					}
				}
			}
		} // END for Mountain
		
//		print(localMap);
//		print(matrix);
		
		// try prim
		boolean[] visited = new boolean[island];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] l, int[] r)->{
			return l[2]-r[2];
		});
		visited[0]=true;
		int totalDist=0;
		for(int i=0;i<island;i++) {
			if(matrix[0][i]!=Integer.MAX_VALUE) {
				pq.add(new int[] {0,i,matrix[0][i]}); // from, to, length
			}
		}
			
		int cnt=0;
		while(!pq.isEmpty()) { // PRIM
			int[] next = pq.poll();
			if(!visited[next[1]]) { // 방문한적 없는 노드면
				cnt++;
				visited[next[1]]=true;
				totalDist+=next[2]; // 최종 거리에 추가.
				for(int i=0;i<island;i++) {
					if(matrix[next[1]][i]!=Integer.MAX_VALUE && !visited[i]) { // 갈 수 있고 방문한적 없으면
						pq.add(new int[] {next[1],i,matrix[next[1]][i]});
					}
				}
			}
			if(cnt==island) {
				break;
			}
		}// END PRIM
		for(int i=0;i<island;i++) {
			if(!visited[i]) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(totalDist);
	}
	
	static void print(int[][] toprint) {
		for(int i=0;i<toprint.length;i++) {
			System.out.println(Arrays.toString(toprint[i]));
		}
	}
}
