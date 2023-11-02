package baekjoon.silver.three;


import java.io.*;
import java.util.*;

public class BJ_19941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        int count = 0;
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        char[] table = br.readLine().toCharArray();
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (table[i] == 'P') {
                for (int j = -k; j <= k; j++) {
                    int cursor = i + j;
                    if (cursor < 0 || cursor >= n) continue;
                    if (table[cursor] == 'H' && !used[cursor]) {
                        used[cursor] = true;
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

}
