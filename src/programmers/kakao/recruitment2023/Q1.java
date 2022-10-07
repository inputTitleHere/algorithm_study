package programmers.kakao.recruitment2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q1 {

	/**
	 * 모든 달은 28일까지 있다고 가정. 번호는 array기준 +1
	 * 
	 * @param today
	 * @param terms
	 * @param privacies
	 * @return
	 */

	public int[] solution(String today, String[] terms, String[] privacies) {

//		String[] todayArr = today.split(".");
		// 오늘날짜를 숫자배열로 보관
		int[] todayInt = dayToIntArr(today);

		Map<String, Integer> termMap = new HashMap<String, Integer>();
		for (String s : terms) {
			String[] input = s.split("\\s");
			termMap.put(input[0], Integer.parseInt(input[1]));
		}

		List<Integer> toDelete = new LinkedList<Integer>();
		for (int i = 0; i < privacies.length; i++) {
			String[] inp = privacies[i].split("\\s");
			// 삭제일
			int[] deleteAfter = addMonth(inp[0], termMap.get(inp[1]));
			if(isDelete(deleteAfter, todayInt)) {
				toDelete.add(i+1);
			}
		}
		int[] result = new int[toDelete.size()];
		for(int i=0;i<toDelete.size();i++) {
			result[i]=toDelete.get(i);
		}
		System.out.println(Arrays.toString(result));
		return result;
	}
	
	public boolean isDelete(int[] deleteAfter, int[] today) {
		// 년
		if(deleteAfter[0]<today[0]) {
			return true;
		}else if(deleteAfter[0]==today[0]) {
			// 월
			if(deleteAfter[1]<today[1]) {
				return true;
			}else if(deleteAfter[1]==today[1]) {
				// 일
				if(deleteAfter[2]<today[2]) {
					return true;
				}
			}
		}
		// 그외
		return false;
	}

	public int[] addMonth(String enrollAt, int month) {
		
		int[] enrollInt = dayToIntArr(enrollAt);
		// 마감계산
		// 일을 하루 빼줘야 한다.
		enrollInt[2]--;
		if(enrollInt[2]==0) {
			enrollInt[2]=28;
			enrollInt[1]--;
		}
		
		enrollInt[1]+=month;
		while(enrollInt[1]>12) {
			enrollInt[0]++;
			enrollInt[1]-=12;
		}
		
		return enrollInt;
	}

	public int[] dayToIntArr(String input) {
		String[] todayArr = input.split("[/.]");
		int[] todayInt = { Integer.parseInt(todayArr[0]), Integer.parseInt(todayArr[1]),
				Integer.parseInt(todayArr[2]) };
		System.out.println(Arrays.toString(todayInt));
		return todayInt;
	}

	public static void main(String[] args) {
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] priva = {"2021.05.02 A","2021.07.01 B","2022.02.19 C","2022.02.20 C"};
		new Q1().solution("2022.05.19", terms , priva);
	}
}
