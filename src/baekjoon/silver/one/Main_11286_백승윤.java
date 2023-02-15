package baekjoon.silver.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// java 11 : 316ms
// java  8 : 280ms
public class Main_11286_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int next;
		for(int i=0;i<n;i++) {
			next = Integer.parseInt(br.readLine());
			if(next!=0) {
				Node nn = new Node(Math.abs(next),next>0);
				pq.add(nn);
			}else { // 0 들어오면
				if(!pq.isEmpty()) {
					Node nn = pq.poll();
					sb.append(nn.isPos?nn.absVal:-nn.absVal).append("\n");					
				}else {
					sb.append(0).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
	static void replace(int[] arr, int from, int to ) {
		int tmp = arr[from];
		arr[from]=arr[to];
		arr[to]=tmp;
	}
	
	private static class Node implements Comparable<Node>{
		int absVal;
		boolean isPos;
		
		public Node(int absVal, boolean isPos) {
			this.absVal = absVal;
			this.isPos = isPos;
		}

		@Override
		public int compareTo(Node o) {
			if(this.absVal == o.absVal) {
				if(this.isPos==o.isPos) {
					return 0;
				}else {
					return this.isPos?1:-1;
				}
			}else {
				return this.absVal - o.absVal;
			}
		}
	}
}



