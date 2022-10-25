package inflearn._8eight;

import java.util.*;
public class Inf08_08 {
	// 모르겠다 ㅋㅋㅋㅋㅋㅋㅋ
	static int[] mult;
	static int f=0;
	static int n = 0;
	static boolean globalFlag = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		mult = new int[n+1];
		f = sc.nextInt();
		
		// 가장 위에는 1부터 N 까지 숫자가 한개씩 적혀있음.
		for(int i=1;i<=n;i++) {
			mult[i] = cases(n-1,i-1);
		}
		int p = 0;
		int[] used = new int[n+1];
		int[] myarr = new int[n+1];
		solve(used, myarr, 1);
	}
	static void solve(int[] used, int[] myarr,int level) {
		if(level>n) {
			int sum=0;
			for(int i=1;i<=n;i++) {
				sum += mult[i]*myarr[i];
			}
			if(sum==f) {
				printCase(myarr);
				globalFlag = true;
				return;
			}
		}else {
			for(int i=1;i<=n;i++) {
				if(globalFlag) return;
				if(used[i]==0) {
					myarr[level]=i;
					used[i]=1;
					solve(used, myarr,level+1);
					used[i]=0;
				}
			}			
		}
	}
	static void printCase(int[] input) {
		for(int i=1;i<=n;i++) {
			System.out.print(input[i]+" ");
		}
		System.out.println();
	}
	
	static int cases(int n, int r) {
		return factorial(n) / (factorial(r) * factorial(n-r));
	}
	static int factorial(int n) {
		int r = 1;
		for(int i=2;i<=n;i++) {
			r*=i;
		}
		return r; 
	}
}
