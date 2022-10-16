package inflearn._6six;

import java.io.*;
import java.util.*;
public class Inf06_05 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br쓰니까 770 ms 걸리는게 404으로 줄어듬 ㅋㅋㅋㅋㅋ (1만개 짜리)
//		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(br.readLine());
//		int[] in = new int[n];
		int i=0;
//		for(i=0;i<n;i++) in[i]=sc.nextInt();
		String[] in = br.readLine().split("\\s");
		
		
		// set이나 hashmap 써도 되긴한다.
		Set<Integer> s = new HashSet<Integer>();
		for(String l:in){
			int k = Integer.parseInt(l);
			if(s.contains(k)) {
				System.out.println("D");
				return;
			}
			s.add(k);
		}
		System.out.println("U");
	}
}
