package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// java 11 : 524ms -> 308ms -> 300ms
public class Main_15683_백승윤 {
	static int n;
	static int m;
	static int limit;
	static int[][] room;
	// up, right, down, left
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static int globalHiddenMin = Integer.MAX_VALUE;
	static List<int[]> camera;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken()); // row
		m = Integer.parseInt(stk.nextToken()); // col

		camera = new ArrayList<int[]>();
		room = new int[n][m];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int next = Integer.parseInt(stk.nextToken());
				room[i][j] = next;
				if (0 < next && next < 6) { // if is camera
					camera.add(new int[] { i, j, 0 });
				}
			}
		} // END of data load

		limit = camera.size();
		dfs(0);
		System.out.println(globalHiddenMin);
	}

	static void dfs(int step) {
		if (step == limit) {
			doSimulation();
			return;
		}
		int[] cam = camera.get(step);
		if (room[cam[0]][cam[1]] == 5) { // in case of type 5 camera, it sees all direction.
			dfs(step + 1);
			
		}else if(room[cam[0]][cam[1]]==2) { // type 2 camera needs only two dir
			for(int i=0;i<2;i++) {
				camera.get(step)[2] = i; // set camera direction
				dfs(step+1);
			}
		}
		else {
			for (int i = 0; i < 4; i++) { // makes combination of camera directions
				camera.get(step)[2] = i; // set camera direction
				dfs(step + 1);
			}
		}
	}

	static void doSimulation() {
		// simulation
		int[][] simul = new int[n][m];
		for (int i = 0; i < n; i++) { // prep simulation room
			System.arraycopy(room[i], 0, simul[i], 0, m);
		}
		// draw camera vision on simulation room
		for (int[] cam : camera) {
			int type = simul[cam[0]][cam[1]];
			// draw by camera type
			project(simul, cam[2], cam[0], cam[1]); // all camera types have a forward vision
			switch (type) {
			case 2:
				project(simul, (cam[2] + 2) % 4, cam[0], cam[1]); // opposite direction
				break;
			case 3:
				project(simul, (cam[2] + 1) % 4, cam[0], cam[1]); // 1 step clockwise
				break;
			case 4:
				project(simul, (cam[2] + 1) % 4, cam[0], cam[1]); // 1 step clockwise
				project(simul, ((cam[2] - 1) % 4 + 4) % 4, cam[0], cam[1]); // 1 step counter-clockwise
				break; // additional processes to catch negative values.
			case 5:
				project(simul, (cam[2] + 2) % 4, cam[0], cam[1]); // opposite direction
				project(simul, (cam[2] + 1) % 4, cam[0], cam[1]); // 1 step clockwise
				project(simul, ((cam[2] - 1) % 4 + 4) % 4, cam[0], cam[1]); // 1 step counter-clockwise
				break;
			default:
				break;
			}
		} // finished drawing

		// count hidden area
		int localHidden = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (simul[i][j] == 0) {
					localHidden++;
				}
			}
		}
		// Test print
//		print(simul);
//		System.out.println(localHidden);
//		System.out.println("+++++++++++++++++++++");
		globalHiddenMin = Math.min(localHidden, globalHiddenMin);
	}

	static void project(int[][] simul, int d, int y, int x) {
		int[] dr = dir[d];
		y += dr[0];
		x += dr[1];
		while (y > -1 && y < n && x > -1 && x < m && simul[y][x] < 6) {
			if (simul[y][x] == 0) { // if visible by camera and unmarked.
				simul[y][x] = -1;
			}
			// in case of 'non-wall objects(other cameras, already marked tiles)' just move
			// along
			y += dr[0];
			x += dr[1];
		}
	}

	static void print(int[][] simul) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int next = simul[i][j];
				if (next < 0) {
					sb.append("#").append(" ");
				} else {
					sb.append(next).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
