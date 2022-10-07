package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1253 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] ai = new int[n];
    StringTokenizer stk = new StringTokenizer(br.readLine());
    for(int i=0;i<n;i++){
      ai[i]=Integer.parseInt(stk.nextToken());
    }
    Arrays.sort(ai);
    int start = 0;
    int end = n-1;
    int sum=0;
    int count=0;
    for(int k=0;k<n;k++){
      int objective = ai[k];
      start=0;
      end=n-1;
      IWHILE : while(start<end){
        sum=ai[start]+ai[end];
        if(sum==objective){
          if(start==k){
            start++;
            continue IWHILE;
          }
          if(end==k){
            end--;
            continue IWHILE;
          }
          count++;
          break;
        }else if(sum>objective){
          end--;
        }else{
          start++;
        }
      }
    }
    System.out.println(count);
  }
}
