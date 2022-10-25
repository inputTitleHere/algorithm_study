package inflearn._9nine;


/**
 * 간선 가중치 오름차순으로 미리 정렬
 * 회로(cycle)만 안생기게 쭉죽 disjoint set으로 연결함
 */
import java.util.*;
public class Inf09_07 {
	static int[] set; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		set = new int[v+1];
		for(int i=0;i<=v;i++) set[i]=i;
		
		ArrayList<Edge> arr = new ArrayList<Edge>();
		for(int i=0;i<e;i++) {
			arr.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(arr);
		
		int tw = 0; // totalWeight
		for(Edge edge : arr) {
			int from = edge.from;
			int to = edge.to;
			int weight = edge.w;
			if(find(from)==find(to)) continue;
			set[find(from)]=to;
			tw+=weight;
		}
		System.out.println(tw);
	}
	static int find(int n) {
		if(set[n]==n) return n;
		else return set[n]=find(set[n]);
	}
}

class Edge implements Comparable<Edge>{
	int from;
	int to;
	int w; // weight
	public Edge(int from, int to, int w){
		this.from=from; this.to=to; this.w=w;
	}
	
	public int compareTo(Edge e) {
		return this.w - e.w; // 가중치에 대한 오름차순.
	}
}

