package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_2001_백승윤 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int[] input = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int n = input[0];
            int m = input[1];
             
            int[][] board = new int[n][];
            for(int i=0;i<n;i++) {
                board[i]=Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            }
            int max=0;
            // 무식하게 고
            for(int i=0;i<n-m+1;i++) {
                for(int j=0;j<n-m+1;j++) {
                    int sum=0;
                    for(int k=0;k<m;k++) {
                        for(int l=0;l<m;l++) {
                            sum+=board[i+l][j+k];
                        }
                    }
                    max = Math.max(sum, max);
                }
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }
}
