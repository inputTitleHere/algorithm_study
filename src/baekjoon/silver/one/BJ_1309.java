package baekjoon.silver.one;

import java.io.*;

public class BJ_1309 {
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    final int MOD = 9901;
    dp = new int[n][3]; // 0칸 배치 1칸 배치 2: 배치안함
    dp[0][0] = 1;
    dp[0][1] = 1;
    dp[0][2] = 1;
    int res = (dp(n-1, 0) + dp(n-1, 1) + dp(n-1, 2)) % MOD;
    System.out.println(res);
  }

  static int dp(int col, int row) {
    final int MOD = 9901;
    if (col < 0) {
      return 0;
    }
    if (dp[col][row] != 0) {
      return dp[col][row];
    }
    if (row == 0) {
      return dp[col][row] = (dp(col - 1, 1) + dp(col - 1, 2)) % MOD;
    }
    if (row == 1) {
      return dp[col][row] = (dp(col - 1, 0) + dp(col - 1, 2)) % MOD;
    }
    // row==2
    return dp[col][row] = (dp(col - 1, 0) + dp(col - 1, 1) + dp(col - 1, 2)) % MOD;
  }
}
