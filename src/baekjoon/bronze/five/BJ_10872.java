package baekjoon.bronze.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10872 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
    int input = Integer.parseInt(br.readLine());
    System.out.println(recursive(input));
  }
  public static int recursive(int input){
    if(input<=1){
      return 1;
    }
    return input*recursive(input-1);
  }
}
