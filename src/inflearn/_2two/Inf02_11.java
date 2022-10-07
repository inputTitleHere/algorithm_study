package inflearn._2two;

import java.util.*;
public class Inf02_11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] t = new int[n][5];
		// 학생별로 같은 반인 적이 있는 학번 set으로 관리
		Map<Integer, Set<Integer>> rmap = new HashMap<Integer, Set<Integer>>();
		// 데이터 삽입
		for(int i=0;i<n;i++) {
			// 학번 = 순서+1 (0부터 시작)
			rmap.put(i+1, new HashSet<Integer>());
			for(int j=0;j<5;j++) { // 학년
				t[i][j]=sc.nextInt();
			}
		}
		for(int j=0;j<5;j++) { // 학년별
			for(int l=1;l<=9;l++) { // 반마다 돌면서(주어지는 정수 모두 1이상 9이하)
				// 예) j학년때 l반인 친구 모두 모여라.
				Set<Integer> stu = new HashSet<Integer>();
				for(int i=0;i<n;i++) { // 학생의 반 체크
					if(t[i][j]==l) { // 어느 반 소속이면 임시set에 추가.
						stu.add(i+1); // 0번부터므로 +1 => 학번
					}
				}
				if(stu.size()<=1) {
					continue;
				}
				// j학년 l반이던 모든 친구들끼리 서로 추가. 
				for(int stuNo:stu) {
					rmap.get(stuNo).addAll(stu);
				}
			}
		}
		int stuMax=0;
		int maxStuNo=1;
		for(int i=1;i<=n;i++) { // 학번대로 돌면서
			if(rmap.get(i).size()>stuMax) {
				maxStuNo=i;
				stuMax=rmap.get(i).size();
			}
		}
		System.out.println(maxStuNo); 
	}
}
