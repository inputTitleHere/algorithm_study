package inflearn._2two;

import java.util.*;
public class Inf02_07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] inputs = sc.nextLine().split("\\s");
		
		int total=0;
		int currScore=1;
		for(String s : inputs) {
			if("1".equals(s)) {
				total+=currScore;
				currScore++;
			}else {
				currScore=1;
			}
		}
		System.out.println(total);
	}
}
