package inflearn._3three;


import java.util.*;
public class Inf03_05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int lt = 1;
		int rt = 1;
		int curr = 0;
		int counter=0;
		for(rt=1;rt<=(int)Math.ceil((double)n/2);rt++) {
			curr+=rt;
			if(curr==n) {
				counter++;
				continue;
			}
			while(curr>n) {
				curr-=lt++;
				if(curr==n) {
					counter++;
				}
			}
		}
		System.out.println(counter);
	}
}
