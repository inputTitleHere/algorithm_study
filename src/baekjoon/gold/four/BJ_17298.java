package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17298 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] resultArray = new int[n];
    Stack<Integer> stack = new Stack<>();
    StringTokenizer stk = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    stack.push(0);

    for(int i=0;i<n;i++){
      arr[i]=Integer.parseInt(stk.nextToken());
      while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]){
        resultArray[stack.pop()]=arr[i];
      }
      stack.push(i);
    }
    while(!stack.isEmpty()){
      resultArray[stack.pop()]=-1;
    }
    
    StringBuffer sb = new StringBuffer();
    for(int i=0;i<n;i++){
      sb.append(resultArray[i]+" ");
    }
    System.out.println(sb.toString());
  }
}
