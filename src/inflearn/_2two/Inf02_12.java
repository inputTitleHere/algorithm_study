package inflearn._2two;

import java.util.*;
public class Inf02_12 {
	public static void main(String[] args) {
		Map<Integer, Set<Integer>> jjack = new HashMap<Integer, Set<Integer>>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		// 각 행은 시험 1회이다. (m개 행 있음)
		int[][] t = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				t[i][j]=sc.nextInt();
			}
		}
		// 초기 가능한 짝 판단
		int[] first = t[0];
		for(int i=0;i<n;i++) {
			Set<Integer> my = new HashSet<Integer>();
			for(int j=i+1;j<n;j++) {
				my.add(first[j]);
			}
			jjack.put(first[i], my);
		}
		// 나머지 케이스 판단.
		for(int i=1;i<m;i++) {
			int[] tc = t[i];
			for(int j=0;j<n;j++) { // 테스트 별 학생마다
				int stuNo=tc[j];
				for(int k=j+1;k<n;k++) {
					if(!jjack.get(stuNo).contains(tc[k])) {
						jjack.get(tc[k]).remove(stuNo);
					}
				}
			}
		}
		int count =0;
		for(int s : jjack.keySet()) {
			count+=jjack.get(s).size();
		}
		System.out.println(count);
	}
}
