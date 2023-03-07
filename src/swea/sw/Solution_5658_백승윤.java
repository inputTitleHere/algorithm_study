package swea.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 115 ms
public class Solution_5658_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int tc = 1;
		while(tc<=t) {
			sb.append("#").append(tc).append(" ");
			stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			int length = n/4;
			
			char[][] box = new char[4][n/4];
			char[] input = br.readLine().toCharArray();
			for(int i=0;i<n;i++) {
				box[i/length][i%length]=input[i];
			}
			
			Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
			for(int z=0;z<length;z++) { // 한변의 길이만큼 회전시킬 수 있음
				for(int r=0;r<4;r++) {
					set.add(Integer.parseInt(new String(box[r]),16));
				}
				rotate(box, n,length);
			}
			sb.append(new ArrayList<>(set).get(k-1)).append("\n");
			
			tc++;
		}
		System.out.println(sb.toString());
	}
	
	static void rotate(char[][] box,int n,int length ) {
		char last = box[(n-1)/length][(n-1)%length];
		int i=n-1;
		while(i>0) {
			box[i/length][i%length] = box[(i-1)/length][(i-1)%length];
			i--;
		}
		box[0][0]=last;
	}
	
}
