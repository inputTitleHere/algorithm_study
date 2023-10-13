package swea.sw;

import java.io.*;
import java.util.*;

/**
 * 시작점에 대해서 진행방향 & 반대방향이 찍혀있으면 스킵하기.
 */
public class Solution_5650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc, t = 0;
        tc = Integer.parseInt(br.readLine().trim());
        StringTokenizer stk;
        while (t++ < tc) {
            sb.append("#").append(t).append(" ");
            int n = Integer.parseInt(br.readLine().trim());
            int maxScore = 0;
            int[][] map = new int[n][n];

            // direction = 0(up),1(right),2(down),3(left)
            boolean[][][] vis = new boolean[n][n][4];
            int[][] wormhole = new int[20][];
            for (int i = 0; i < n; i++) {
                stk = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < n; j++) {
                    int next = Integer.parseInt(stk.nextToken());
                    if (5 < next) {
                        int[] pos = new int[2];
                        pos[0] = i;
                        pos[1] = j;
                        if (wormhole[next] != null) {
                            next += 5;
                        }
                        wormhole[next] = pos;
                    }
                    map[i][j] = next;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 0) {
                        for (int d = 0; d < 4; d++) {
                            // 양방향으로 방문했으면
                            maxScore = Math.max(maxScore, simulate(i, j, d, map, vis, wormhole, n));
                        }
                    }
                }
            }
            sb.append(maxScore).append("\n");
        }
        System.out.println(sb);
    }

    // direction = 0(up),1(right),2(down),3(left)
    static int simulate(int y, int x, int d, int[][] map, boolean[][][] vis, int[][] wormhole, int n) {
        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int score = 0;
        vis[y][x][d] = true;
        int py = y;
        int px = x;
        do {
            py += move[d][0];
            px += move[d][1];
            // 찐 벽
            if (py < 0 || py >= n || px < 0 || px >= n) {
                score++;
                d = (d + 2) % 4;
                continue;
            }
            // 블랙홀!
            if (map[py][px] == -1) {
                break;
            }
            // 블럭
            if (0 < map[py][px] && map[py][px] < 6) {
                score++;
                // 0(up),1(right),2(down),3(left)
                switch (map[py][px]) {
                    case 1:
                        d = rotate(d, 3, 2);
                        break;
                    case 2:
                        d = rotate(d, 0, 3);
                        break;
                    case 3:
                        d = rotate(d, 1, 0);
                        break;
                    case 4:
                        d = rotate(d, 2, 1);
                        break;
                    case 5:
                        d = (d + 2) % 4;
                        break;
                }
                continue;
            }
            // 웜홀
            if (5 < map[py][px]) {
                int pos = map[py][px];
                if (pos > 10) pos -= 5;
                else pos += 5;
                py = wormhole[pos][0];
                px = wormhole[pos][1];
                continue;
            }
            // 다 통과하고 단순 이동일 경우
            vis[py][px][d] = true;
        } while (py != y || px != x);
        return score;
    }

    static int rotate(int d, int clock, int antiClock) {
        if (d == clock) return (d + 1) % 4;
        else if (d == antiClock) return (d + 3) % 4;
        else return (d + 2) % 4;
    }

}
