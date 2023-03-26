package baekjoon._contest.UNIST_DGIST_POSTECH_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] ord = new int[n];
		StringBuilder sb = new StringBuilder();
		sb.append("YES\n");
		
		int trk = 0;
		int pos=0;
		int m = n-1;
		boolean goRight=true;
		while(m>0) {
			arr[pos]=m;
			ord[trk++]=pos+1;
			if(goRight) {
				pos+=m--;
				goRight=false;
			}else {
				pos-=m--;
				goRight=true;
			}
		}
		arr[pos]=n;
		ord[trk]=pos+1;
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(ord));
		for(int i : arr) {
			sb.append(i).append(" ");
		}
		sb.append("\n");
		for(int i: ord) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}
}

/*
4 2 5 1 3

1 2 3 4 5 6
5 3 1 6 2 4
6 4 2 7 1 3 5
*/