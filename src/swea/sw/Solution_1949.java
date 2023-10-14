package swea.sw;

import java.io.*;
import java.util.*;

public class Solution_1949 {

  static int n;
  static int k;

  static int maxLen;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer stk;

    int tcase = 0, t = Integer.parseInt(br.readLine());
    while (tcase++ < t) {
      sb.append("#").append(tcase).append(" ");
      stk = new StringTokenizer(br.readLine());
      n = Integer.parseInt(stk.nextToken());
      k = Integer.parseInt(stk.nextToken());
      maxLen = Integer.MIN_VALUE;

      int[][] map = new int[n][n];
      int top = 0;
      for (int i = 0; i < n; i++) {
        stk = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          int next = Integer.parseInt(stk.nextToken());
          map[i][j] = next;
          top = Math.max(top, next);
        }
      }
      List<int[]> candidate = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (map[i][j] == top) {
            candidate.add(new int[]{i, j});
          }
        }
      }

      for (int[] mountain : candidate) {
        boolean[][] vis = new boolean[n][n];
        vis[mountain[0]][mountain[1]] = true;
        dfs(mountain[0],mountain[1],1,map,vis,true);
      }
      sb.append(maxLen).append("\n");
    }
    System.out.println(sb);
  }

  static void dfs(int y, int x, int len, int[][] map, boolean[][] vis, boolean diggable) {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    maxLen=Math.max(maxLen,len);
    for (int d = 0; d < 4; d++) {
      int ny = y + dir[d][0];
      int nx = x + dir[d][1];
      if (ny >= 0 && ny < n && nx >= 0 && nx < n && !vis[ny][nx]) {
        if(map[y][x]>map[ny][nx]){
          vis[ny][nx]=true;
          dfs(ny,nx,len+1,map,vis,diggable);
          vis[ny][nx]=false;
        }else if(diggable && (map[ny][nx]-map[y][x]<k)){
          vis[ny][nx]=true;
          int ori = map[ny][nx];
          map[ny][nx]=map[y][x]-1;
          dfs(ny,nx,len+1,map,vis,false);
          map[ny][nx]=ori;
          vis[ny][nx]=false;
        }
      }
    }
  }

}
