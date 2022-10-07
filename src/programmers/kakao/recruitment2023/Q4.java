package programmers.kakao.recruitment2023;

import java.util.*;

public class Q4 {

	public int[] solution(long[] numbers) {

		int[] answer = new int[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			long l = numbers[i];
			StringBuilder sb = new StringBuilder();
			while (l > 0) {
				sb.append(l % 2);
				l /= 2;
			}
			int length = sb.length();
			System.out.println("length = " + length);
			int pos = 0;
			while (length > 0) {
				pos++;
				length /= 2;
			}
			System.out.println("pos = " + pos);
			int toFill = (int) Math.pow(2, pos) - 1 - sb.length();
			for (int j = 0; j < toFill; j++) {
				sb.append(0);
			}
			sb.reverse();
			String toCheck = sb.toString();
			if(toCheck.charAt(toCheck.length()/2)=='0') {
				answer[i]=0;
				continue;
			}else {
				if(isTreeable(toCheck, '1')) {
					answer[i]=1;
				}
			}
		}
		System.out.println("Answer = "+Arrays.toString(answer));
		return answer;
	}

	
	public boolean isTreeable(String check, char parent) {
		if(check.length()==1) {
			if(parent=='1') {
				return true;
			}else {
				if(check.charAt(0)=='1') {
					return false;
				}else {
					return true;
				}
			}
		}
		
		
		int center = check.length() / 2;
		if (check.charAt(center) == '1') {
			// 부모가 이미 0인데 자식이 1이면.
			if (parent == '0') {
				return false;
			}
		}
		return isTreeable(check.substring(0, center), check.charAt(center))
				&& isTreeable(check.substring(center + 1), check.charAt(center));

	}

	public static void main(String[] args) {

		long[] l = { 7,5 };
		new Q4().solution(l);

	}
}

