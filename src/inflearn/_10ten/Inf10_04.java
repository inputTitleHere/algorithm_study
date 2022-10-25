package inflearn._10ten;

import java.util.*;
public class Inf10_04 {
	
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Brick> arr = new ArrayList<>();
		for(int i=0;i<n;i++) arr.add(new Brick(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		Collections.sort(arr); // width에 대해 정렬됨, weight만 고려
		// ArrayList는 탐색이 O(1)이라고 한다.(탐색도 아니라 그냥 array처럼 접근한다고함)
		dp = new int[n];
		dp[0]=arr.get(0).height;
		for(int i=1;i<n;i++) {
			Brick b = arr.get(i);
			int max = b.height;
			for(int j=i-1;j>=0;j--) {
				Brick other = arr.get(j);
				if(other.weight>b.weight) {
					max = Math.max(max, dp[j]+b.height);
				}
			}
			dp[i]=max;
		}
		
		int max = 0;
		for(int i=0;i<n;i++) {
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
class Brick implements Comparable<Brick>{
	int width;
	int height;
	int weight;
	public Brick(int w, int h, int wei) {
		this.height=h; this.width=w;this.weight=wei;
	}
	
	@Override
	public int compareTo(Brick b) {
		return b.width-this.width;
	}
}

