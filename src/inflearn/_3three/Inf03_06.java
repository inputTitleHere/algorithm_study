package inflearn._3three;

import java.util.*;
public class Inf03_06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] in = new int[n];
		for(int i=0;i<n;i++) {
			in[i]=sc.nextInt();
		}
		
		// 해결
		Queue<Integer> zeroPos = new LinkedList<Integer>();
		int rt=0;
		int max=0;
		int length=0;
		for(rt=0;rt<n;rt++) {
			if(in[rt]==1) {
				length++;
				if(max<length) {
					max=length;
				}
				continue;
			}else { // 0인 경우
				if(zeroPos.size()<k) { // 여유가 있으면
					length++;
					zeroPos.offer(rt);
					if(max<length) {
						max=length;
					}
				}else { // 0개수 한계치에 도달했으면
					length=rt-zeroPos.poll();
					zeroPos.offer(rt);
				}
			}
		}
		System.out.println(max);
	}
}
