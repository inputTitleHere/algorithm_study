package inflearn._3three;

import java.util.*;
public class Inf03_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int lp = 0, rp = 0;
		int curr = arr[lp] ;
		int counter =  0;
		while(rp<n-1) {
			if(curr<m) {
				curr+=arr[++rp];
				continue;
			}else if(curr>m) { // curr>m
				curr-=arr[lp++];
				continue;
			}else { // curr==m -> true	
				counter++;
				curr+=arr[++rp]-arr[lp++];
				continue;
			}
		}
		// rp는 n-1(마지막 아이템)에 걸쳐진 상태
		while(lp<=rp) {
			if(curr<m) {
				break;
			}
			if(curr==m) {
				counter++;
				break;
			}
			curr-=arr[lp++];
		}
		System.out.println(counter);
	}
}
