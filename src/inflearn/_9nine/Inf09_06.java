package inflearn._9nine;

import java.util.*;
public class Inf09_06 {
	static int[] fmap; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 학생수
		int m = sc.nextInt(); // 친구관계 수
		fmap = new int[n+1];
		for(int i=0;i<=n;i++) fmap[i]=i;
		
		for(int i=0;i<m;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			fmap[find(from)]=find(to);
		}
		int from = sc.nextInt();
		int to = sc.nextInt();
		if(find(from)==find(to)) System.out.println("YES");
		else System.out.println("NO");
		
	}
	static int find(int f) {
		if(f==fmap[f]) return f;
		return fmap[f]=find(fmap[f]);
	}
}
