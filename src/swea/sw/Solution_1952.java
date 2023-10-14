package swea.sw;

import java.io.*;
import java.util.*;

public class Solution_1952 {

  static int[] dp;
  static int[] price;
  static int[] plan;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stk;
    StringBuilder sb = new StringBuilder();

    int tcase = 0, t = Integer.parseInt(br.readLine());
    while (tcase++ < t) {
      sb.append("#").append(tcase).append(" ");
      price = new int[4]; // 1 day, 1month, 3month, 1year
      plan = new int[13];
      dp = new int[13];
      Arrays.fill(dp, -1);

      stk = new StringTokenizer(br.readLine());
      for (int i = 0; i < 4; i++) {
        price[i] = Integer.parseInt(stk.nextToken());
      }
      stk = new StringTokenizer(br.readLine());
      for (int i = 1; i <= 12; i++) {
        plan[i] = Integer.parseInt(stk.nextToken());
      }
      dp[0] = 0;

      sb.append(Math.min(dp(12),price[3])).append("\n");
//      System.out.println(Arrays.toString(dp));
    }

    System.out.println(sb);

  }

  static int dp(int pos) {
    if (pos < 0) {
      return 9999999;
    }
    if (dp[pos] != -1) {
      return dp[pos];
    }
    int thisMonth = Math.min(plan[pos] * price[0], price[1]);
    dp[pos] = Math.min(dp(pos - 1)+thisMonth, dp(pos - 3)+price[2]);
    return dp[pos];
  }

}
