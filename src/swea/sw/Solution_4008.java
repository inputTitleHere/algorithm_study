package swea.sw;

import java.io.*;
import java.util.*;

public class Solution_4008 {

  static int n;
  static int[] operator;
  static int[] opRef = {(int) '+', (int) '-', (int) '*', (int) '/'};
  static int[] numbers;
  static int[] expression;

  static int gmin;
  static int gmax;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer stk;
    int tcase = 0, t = Integer.parseInt(br.readLine());
    while (tcase++ < t) {
      sb.append("#").append(tcase).append(" ");
      gmin = Integer.MAX_VALUE;
      gmax = Integer.MIN_VALUE;

      n = Integer.parseInt(br.readLine());
      // +, -, *, /
      stk = new StringTokenizer(br.readLine());
      operator = new int[4];
      for (int i = 0; i < 4; i++) {
        operator[i] = Integer.parseInt(stk.nextToken());
      }
      stk = new StringTokenizer(br.readLine());
      numbers = new int[n];
      for (int i = 0; i < n; i++) {
        numbers[i] = Integer.parseInt(stk.nextToken());
      }
      expression = new int[n * 2 - 1];
      dfs(0);
      sb.append(gmax - gmin).append("\n");
    }
    System.out.println(sb);
  }

  static void dfs(int step) {
    if (step == n * 2 - 1) {
      int calc = expression[0];
      for (int i = 1; i < n * 2 - 1; i += 2) {
        switch ((char) expression[i]) {
          case '+':
            calc += expression[i + 1];
            break;
          case '-':
            calc -= expression[i + 1];
            break;
          case '*':
            calc *= expression[i + 1];
            break;
          case '/':
            calc /= expression[i + 1];
            break;
        }
      }
      gmax = Math.max(calc, gmax);
      gmin = Math.min(calc, gmin);
      return;
    }
    if (step % 2 == 0) { // 숫자
      expression[step] = numbers[step / 2];
      dfs(step + 1);
    } else { // 연산자
      for (int i = 0; i < 4; i++) {
        if (operator[i] > 0) {
          expression[step] = opRef[i];
          operator[i]--;
          dfs(step + 1);
          operator[i]++;
        }
      }
    }
  }

}
