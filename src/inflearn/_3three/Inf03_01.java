package inflearn._3three;

import java.util.*;
public class Inf03_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 데이터 입력부
		int n = sc.nextInt();
		int[] nArr = new int[n];
		for(int i=0;i<n;i++) {
			nArr[i]=sc.nextInt();
		}
		int m = sc.nextInt();
		int[] mArr = new int[m];
		for(int i=0;i<m;i++) {
			mArr[i]=sc.nextInt();
		}
		// 해결부
		StringBuilder sb = new StringBuilder();
		int np=0;
		int mp=0;
		// 입력된 배열은 각자 오름차순으로 정렬되어있음.
		while(np<n && mp<m) { // 한쪽 배열이 빌때까지 // 큐 써도 됨.
			sb.append(nArr[np]<=mArr[mp]?nArr[np++]+" ":mArr[mp++]+" ");
		}
		// 남은 배열 출력
		for(int i=np;i<n;i++) {
			sb.append(nArr[i]+" ");
		}
		for(int i=mp;i<m;i++) {
			sb.append(mArr[i]+" ");
		}
		System.out.println(sb.toString());
	}
}
