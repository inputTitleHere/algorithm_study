package inflearn._1one;

import java.util.Scanner;

public class Inf01_01 {
  // 1. 문자 찾기
  public static void main(String[] args) {
    int diff = 'a' - 'A';
    int counter = 0;
    Scanner sc = new Scanner(System.in);
    char[] input = sc.nextLine().toCharArray();
    char toFind = sc.nextLine().charAt(0);
    if(toFind>='a'){
      toFind=(char)(toFind-diff);
    }
    for(char c : input){
      if(c>='a'){
        c=(char)(c-diff);
      }
      if(c==toFind){
        counter++;
      }
    }
    System.out.println(counter);
  }
}