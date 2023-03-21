package baekjoon.gold.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1967 {
	
	static List<Integer> leaf;
	static boolean[] visited;
	static List<ArrayList<int[]>> tree;
	static int maxLen=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList<>(); // [to,dist]
		for(int i=0;i<=n;i++) {
			tree.add(new ArrayList<>());
		}
		
		leaf = new ArrayList<>();
		
		for(int i=0;i<n-1;i++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());
			
			tree.get(from).add(new int[] {to,dist});
			tree.get(to).add(new int[] {from,dist});
			
		}
		visited = new boolean[n+1];
		
		// 리프노드 추출
		for(int i=0;i<n;i++) {
			if(tree.get(i).size()==1) {
				// leaf노드이면
				visited[i]=true;
				dfs(i,0);
			}
		}
		
		System.out.println(maxLen);
	}
	static void dfs(int currNode, int len) {
		
		List<int[]> near = tree.get(currNode);
		if(near.size()==1) { // 끝 노드임
			maxLen=Math.max(maxLen, len);
		}
		
		for(int[] i : near) {
			if(!visited[i[0]]) {
				visited[i[0]]=true;
				dfs(i[0],len+i[1]);
				visited[i[0]]=false;
			}
		}
	}
}
