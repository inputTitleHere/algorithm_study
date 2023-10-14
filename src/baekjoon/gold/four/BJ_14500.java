package baekjoon.gold.four;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BJ_14500 {

  static int n;
  static int m;

  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stk = new StringTokenizer(br.readLine());
    n = Integer.parseInt(stk.nextToken());
    m = Integer.parseInt(stk.nextToken());
    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      stk = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(stk.nextToken());
      }
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        max = Math.max(max, IntStream.of(linear(i, j), square(i, j), shape(i, j)).max().orElse(0));
      }
    }
    System.out.println(max);

  }

  static int linear(int i, int j) {
    int hori = 0;
    if (j + 3 < m) {
      for (int s = j; s < j + 4; s++) {
        hori += map[i][s];
      }
    }
    int verti = 0;
    if (i + 3 < n) {
      for (int s = i; s < i + 4; s++) {
        verti += map[s][j];
      }
    }

    return Math.max(verti, hori);
  }

  static int square(int i, int j) {
    if (i + 1 < n && j + 1 < m) {
      return map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1];
    }
    return 0;
  }

  static int shape(int i, int j) {
    int[] results = new int[8];
    if (i + 2 < n && j + 1 < m) {
      results[0] = map[i][j] + map[i + 1][j] + IntStream.of(
              map[i + 2][j] + map[i + 2][j + 1],
              map[i + 1][j + 1] + map[i + 2][j + 1],
              map[i + 1][j + 1] + map[i + 2][j]
      ).max().orElse(0);

    }
    if (i + 2 < n && j - 1 >= 0) {
      results[1] = map[i][j] + map[i + 1][j] + IntStream.of(
              map[i + 2][j] + map[i + 2][j - 1],
              map[i + 1][j - 1] + map[i + 2][j - 1],
              map[i + 1][j - 1] + map[i + 2][j]
      ).max().orElse(0);
    }

    if (i - 1 >= 0 && j + 2 < m) {
      results[2] = map[i][j] + map[i][j + 1] + IntStream.of(
              map[i][j + 2] + map[i - 1][j + 2],
              map[i - 1][j + 1] + map[i - 1][j + 2],
              map[i - 1][j + 1] + map[i][j + 2]
      ).max().orElse(0);
    }
    if (i + 1 < n && j + 2 < m) {
      results[3] = map[i][j] + map[i][j + 1] + IntStream.of(
              map[i][j + 2] + map[i + 1][j + 2],
              map[i + 1][j + 1] + map[i + 1][j + 2],
              map[i + 1][j + 1] + map[i][j + 2]
      ).max().orElse(0);
    }

    if (i - 2 >= 0 && j - 1 >= 0) {
      results[4] = map[i][j] + map[i - 1][j] + IntStream.of(
              map[i - 2][j] + map[i - 2][j - 1],
              map[i - 1][j - 1] + map[i - 2][j - 1],
              map[i - 1][j - 1] + map[i - 2][j]
      ).max().orElse(0);
    }
    if (i - 2 >= 0 && j + 1 < m) {
      results[5] = map[i][j] + map[i - 1][j] + IntStream.of(
              map[i - 2][j] + map[i - 2][j + 1],
              map[i - 1][j + 1] + map[i - 2][j + 1],
              map[i - 1][j + 1] + map[i - 2][j]
      ).max().orElse(0);
    }

    if (i + 1 < n && j - 2 >= 0) {
      results[6] = map[i][j] + map[i][j - 1] + IntStream.of(
              map[i][j - 2] + map[i + 1][j - 2],
              map[i + 1][j - 1] + map[i + 1][j - 2],
              map[i + 1][j - 1] + map[i][j - 2]
      ).max().orElse(0);
    }
    if (i - 1 >= 0 && j - 2 >= 0) {
      results[7] = map[i][j] + map[i][j - 1] + IntStream.of(
              map[i][j - 2] + map[i - 1][j - 2],
              map[i - 1][j - 1] + map[i - 1][j - 2],
              map[i - 1][j - 1] + map[i][j - 2]
      ).max().orElse(0);
    }
    return IntStream.of(results).max().orElse(0);
  }


}
