package baekjoon.bronze.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10870 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());
    System.out.println(fibonacci(input));
  }
  public static int fibonacci(int input){
    if(input==0){
      return 0;
    }if(input==1){
      return 1;
    }
    return fibonacci(input-1)+fibonacci(input-2);
  }
}
