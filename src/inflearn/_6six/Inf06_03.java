package inflearn._6six;

import java.io.*;
import java.util.*;
public class Inf06_03 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] in = new int[n];
		int i=0;
		int j=0;
		for(i=0;i<n;i++) in[i]=sc.nextInt();
		
		// 삽입정렬
		// 수를 찾아서 앞에서부터 위치를 찾은 다음에 끼워넣는다.
		// System.arraycopy(원본배열, 시작위치, 타겟배열, 타겟위치, 길이)를 사용해보자. -> native 함수로 아마 윈도우 레벨에 박혀있을 것으로 추정. 
		
		MAIN:for(i=1;i<n;i++) { // 탐색할것 
			for(j=0;j<i;j++) { // 처음부터 정렬된 위치까지.
				if(in[i]<in[j]) { // 더 큰수를 찾으면 그 위치에 두기
					int t = in[i];
					System.arraycopy(in, j, in, j+1, i-j);
					in[j]=t;
					continue MAIN;
				}
			}
			// 다 돌았는데 못찾은 경우(제일 뒤인 경우) -> continue으로 잡음
			// 아무것도 안해도 될듯
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(i=0;i<n;i++) bw.write(in[i]+" ");
		bw.flush();
		bw.close();
	}
}
