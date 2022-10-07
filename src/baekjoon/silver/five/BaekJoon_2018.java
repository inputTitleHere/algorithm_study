package baekjoon.silver.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_2018 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int start_idx = 1;
    int end_idx = 1;
    int sum=1;
    int count=1; // 기본적으로 n일때 1회 성립.
    while(end_idx!=n){
      if(sum==n){
        count++;
        end_idx++;
        sum+=end_idx;
        continue;
      }
      if(sum<n){
        end_idx++;
        sum+=end_idx;
        continue;
      }
      if(sum>n){
        sum-=start_idx;
        start_idx++;
        continue;
      }
    }
    System.out.println(count);
  }
}
