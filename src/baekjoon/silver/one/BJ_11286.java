package baekjoon.silver.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_11286 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i1,i2)->{
      int i1_abs=Math.abs(i1);
      int i2_abs=Math.abs(i2);
      if(i1_abs==i2_abs){
        return i1>i2?1:-1;
      }else{
        return i1_abs-i2_abs;
      }
    });

    for(int i=0;i<n;i++){
      int input = Integer.parseInt(br.readLine());
      if(input==0){
        if(pq.isEmpty()){
          sb.append(0+"\n");
        }else{
          sb.append(pq.poll()+"\n");
        }
      }else{
        pq.offer(input);
      }
    }
    System.out.println(sb.toString());
  }
}
