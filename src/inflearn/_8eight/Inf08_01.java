package inflearn._8eight;

import java.util.*;
public class Inf08_01 {
	
	static String result = "NO";
	static Stack<Integer> left = new Stack<Integer>();
	static Stack<Integer> right = new Stack<Integer>();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] in = new int[n];
		for(int i=0;i<n;i++) in[i]=sc.nextInt();
		// ------ //
		seek(in, 0,n);
		System.out.println(result);
	}
	public static void seek(int[] in, int curr, int max) {
		if(curr==max) {
			int leftSum = left.stream().reduce(0, Integer::sum);
			int rightSum = right.stream().reduce(0, Integer::sum);
			if(leftSum==rightSum) result = "YES";
			return;
		}
		int current = in[curr];
		left.push(current);
		seek(in,curr+1, max);
		left.pop();
		
		right.push(current);
		seek(in, curr+1, max);
		right.pop();
	}
}
