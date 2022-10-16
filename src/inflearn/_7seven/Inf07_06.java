package inflearn._7seven;

import java.util.*;
public class Inf07_06 {
	
	static int n;
	static int[] ch;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ch=new int[n+1];
		sc.close();
		
		scan(1);
	}
	
	static String scan(int l) {
		if(l==n+1) {
			StringBuilder sb = new StringBuilder();
			for(int i=1;i<=n;i++) {
				if(ch[i]==1) {
					sb.append(i).append(" ");
				}
			}
			if(sb.length()>0) {
				System.out.println(sb.toString());				
			}
		}else {
			ch[l]=1;
			scan(l+1);
			ch[l]=0;
			scan(l+1);
		}
		
		
		return null;
	}
	
}
