package swea.sw;

import java.io.*;
import java.util.*;

public class Solution_2112 {

  static int d;
  static int w;
  static int k;
  static int placed;

  static int[] A;
  static int[] B;

  static boolean[] vis;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer stk;
    int tcase = 0, t = Integer.parseInt(br.readLine());
    while (tcase++ < t) {
      sb.append("#").append(tcase).append(" ");
      stk = new StringTokenizer(br.readLine());
      d = Integer.parseInt(stk.nextToken());
      w = Integer.parseInt(stk.nextToken());
      k = Integer.parseInt(stk.nextToken());
      placed = k;
      int[][] film = new int[d][w];
      A = new int[w];
      B = new int[w];
      Arrays.fill(B, 1);
      vis = new boolean[d];

      for (int i = 0; i < d; i++) { // load Data
        stk = new StringTokenizer(br.readLine());
        for (int j = 0; j < w; j++) {
          film[i][j] = Integer.parseInt(stk.nextToken());
        }
      }
      for (int i = 1; i <= k; i++) {
        if(dfs(0, 0, film, i)) break;
      }
      sb.append(placed).append("\n");
    }
    System.out.println(sb);
  }

  static void print(int[][] film) {
    for (int i = 0; i < d; i++) {
      System.out.println(Arrays.toString(film[i]));
    }
  }

  static boolean dfs(int step, int placeCount, int[][] film, int allowed) {
    if (step == d) {
//      System.out.println("-----------------");
//      System.out.println("Place count = " + placeCount);
      if (checkMatch(film)) {
        placed = placeCount;
//        System.out.println("MATCH!!");
        return true;
      } else {
        return false;
      }
    }
    // apply no chemical in this level
    if (dfs(step + 1, placeCount, film, allowed)) return true;

    // apply chemical A
    if (allowed > 0) {
      int[] ori = film[step];

      film[step] = A;
      if (dfs(step + 1, placeCount + 1, film, allowed - 1)) return true;

      // apply chemical B
      film[step] = B;
      if (dfs(step + 1, placeCount + 1, film, allowed - 1)) return true;

      film[step] = ori;
    }

    return false;
  }

  static boolean checkMatch(int[][] f) {
//    print(f);
    boolean isUsable = true;
    int ho = 0; // Horizontal Offset
    while (isUsable && ho < w) {
      int maxlen = 1;
      int mode = f[0][ho];
      int cont = 1;
      for (int i = 1; i < d; i++) {
        if (f[i][ho] == mode) {
          cont++;
          maxlen=Math.max(maxlen,cont);
        } else {
          mode = f[i][ho];
          cont = 1;
        }
      }
      if (maxlen < k) {
        isUsable = false;
      }
      ho++;
    }
    return isUsable;
  }

}
