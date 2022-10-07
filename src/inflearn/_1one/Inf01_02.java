package inflearn._1one;

import java.util.Scanner;

public class Inf01_02 {
	public static void main(String[] args) {
    int diff = 'a'-'A';
		Scanner sc = new Scanner(System.in);
    char[] input = sc.nextLine().toCharArray();
    char[] output = new char[input.length];

    for(int i=0;i<input.length;i++){
      if(input[i]<='Z'){
        output[i]=(char)(input[i]+diff);
      }else{
        output[i]=(char)(input[i]-diff);
      }
    }
    String res = String.copyValueOf(output);
    System.out.println(res);
	}
}
