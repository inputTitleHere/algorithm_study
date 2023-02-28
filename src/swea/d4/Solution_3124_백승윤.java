package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_백승윤 {
	
	static int[] parents;
	static int v,e;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			stk = new StringTokenizer(br.readLine());
			v = Integer.parseInt(stk.nextToken());
			e = Integer.parseInt(stk.nextToken());
			// A to B weight C 입력
			int[][] edgelist = new int[e][3];
			for(int i=0;i<e;i++) {
				stk = new StringTokenizer(br.readLine());
				edgelist[i][0]=Integer.parseInt(stk.nextToken());
				edgelist[i][1]=Integer.parseInt(stk.nextToken());
				edgelist[i][2]=Integer.parseInt(stk.nextToken());
			}
			Arrays.sort(edgelist,(int[] l1, int[] l2)->{
				return l1[2]-l2[2];
			});
			
			int cnt = 0;
			long weightsum=0;
			makeset();
			for(int[] edge : edgelist) {
				if(unionset(edge[0], edge[1])) {
					weightsum+=edge[2];
					if(++cnt == v-1) break;
				}
			}
			sb.append(weightsum).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void makeset() {
		parents=new int[v+1];
		for(int i=0;i<v+1;i++) {
			parents[i]=i;
		}
	}
	static int findset(int a) {
		if(a==parents[a]) return a;
		return parents[a]=findset(parents[a]);
	}
	static boolean unionset(int a , int b) {
		int ar = findset(a);
		int br = findset(b);
		if(ar==br) {
			return false;
		}
		parents[ar]=br;
		return true;
	}
}
