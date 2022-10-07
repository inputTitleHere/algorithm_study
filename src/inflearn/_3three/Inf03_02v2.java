package inflearn._3three;

import java.util.*;
public class Inf03_02v2 {
	// 이게 더 느리네 ㅋㅋㅋ
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Set<Integer> nset = new HashSet<Integer>();
		for(int i=0;i<n;i++) {
			nset.add(sc.nextInt());
		}
		int m = sc.nextInt();
		Set<Integer> mset = new HashSet<Integer>();
		for(int i=0;i<m;i++) {
			mset.add(sc.nextInt());
		}
		// 교차부 추출(mset에 없는 nset의 요소를 제거)
		List<Integer> result = new ArrayList<Integer>();
		for(int i : nset) {
			if(mset.contains(i)) {
				result.add(i);
			}
		}
		result.sort(Comparator.naturalOrder());
		StringBuilder sb = new StringBuilder();
		for(int i : result) {
			sb.append(i).append(" ");
		}

		System.out.println(sb.toString());
	}
}
