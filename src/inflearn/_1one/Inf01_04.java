package inflearn._1one;

import java.util.Scanner;

public class Inf01_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    int cases = Integer.parseInt(sc.nextLine());
    StringBuilder sb = new StringBuilder();

    for(int i=0;i<cases;i++){
      char[] input = sc.nextLine().toCharArray();
      char[] output = new char[input.length];
      for(int j=input.length;j>0;j--){
        output[input.length-j]=input[j-1];
      }
      sb.append(String.valueOf(output)+"\n");
    }
    System.out.println(sb.toString());
	}
}
