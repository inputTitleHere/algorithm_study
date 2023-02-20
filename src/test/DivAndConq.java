package test;

public class DivAndConq {
	
	private static int callCnt1=0, callCnt2=0;
	
	public static void main(String[] args) {
		int x = 2;
		int n = 20;
		System.out.println(exp1(x,n));
		System.out.println(callCnt1);
		System.out.println(exp2(x,n));
		System.out.println(callCnt2);
	}
	
	private static long exp1(long x, long n) {
		callCnt1++;
		if(n==1)return x;
		return x * exp1(x,n-1);
	}
	
	private static long exp2(long x, long n) {
		callCnt2++;
		if(n==1)return x;
		if(n%2==0) {
			long y = exp2(x,n/2);
			return y*y;
		}else {
			long y = exp2(x,(n-1)/2);
			return y*y*x;
		}
		
	}
	
}
