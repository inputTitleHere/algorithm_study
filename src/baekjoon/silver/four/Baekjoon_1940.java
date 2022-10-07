package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1940 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    int[] mat = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0;i<n;i++){
      mat[i]=Integer.parseInt(st.nextToken());
    }
    Arrays.sort(mat); // 정렬 가능.
    int start_ptr=0;
    int end_ptr=n-1;
    int count=0;
    int sum = 0;
    while(start_ptr<end_ptr){
      sum=mat[start_ptr]+mat[end_ptr];
      if(sum==m){
        count++;
        start_ptr++;
        continue;
      }
      if(sum<m){
        start_ptr++;
        continue;
      }
      if(sum>m){
        end_ptr--;
        continue;
      }
    }
    System.out.println(count);
  }
}
