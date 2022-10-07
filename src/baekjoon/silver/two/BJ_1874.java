package baekjoon.silver.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1874 {
  static int tracker = 1;
  static int pointer = 0;
  static Stack<Integer> stack = new Stack<Integer>();
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int cases = Integer.parseInt(br.readLine());
    int[] numArr = new int[cases];
    for(int i=0;i<cases;i++){
      numArr[i]=Integer.parseInt(br.readLine());
    }
    while(pointer<cases){
      if(stack.isEmpty()){
        push(tracker);
      }else if(stack.peek()<numArr[pointer]){
        push(tracker);
      }else if(stack.peek()==numArr[pointer]){
        pop();
      }else if(stack.peek()>numArr[pointer]){
        System.out.println("NO");
        return;
      }
    }
    System.out.println(sb.toString());
  }
  public static void push(int number){
    stack.push(number);
    sb.append("+\n");
    tracker++;
  }
  public static void pop(){
    pointer++;
    stack.pop();
    sb.append("-\n");
  }
}
