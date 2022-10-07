package inflearn._2two;

//* 영상 한번 보기

import java.util.*;
public class Inf02_08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] inputs = sc.nextLine().split("\\s");
		// 만점은 100이라고 가정
		int[] scoreTable = new int[101];
		int[] resT = new int[101];
		for(String s : inputs) {
			scoreTable[Integer.parseInt(s)]++;
		}
		int counter = 1;
		for(int i=100;i>0;i--) {
			resT[i]=counter;
			counter+=scoreTable[i];
		}
		StringBuilder sb= new StringBuilder();
		for(String s : inputs) {
			sb.append(resT[Integer.parseInt(s)]);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
