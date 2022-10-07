package programmers.kakao.recruitment2022;

import java.util.*;

public class Question_3 {

	public int[] solution(int[] fees, String[] records) {
		int baseTime = fees[0];
		int basePrice = fees[1];
		int unitTime = fees[2];
		int unitPrice = fees[3];
		
		Map<String, Queue<String>> timeMap = new HashMap<String, Queue<String>>();
		Set<String> car = new HashSet<String>();
		for(String s : records) {
			String[] input = s.split(" ");
			if(!car.contains(input[1])) {
				car.add(input[1]);
				Queue<String> l = new LinkedList<String>();
				l.add(input[0]);
				timeMap.put(input[1], l);
			}else {
				timeMap.get(input[1]).add(input[0]);
			}
		}
		String[] ordered = car.stream().sorted().toArray(String[]::new);
		int[] timeElapsed = new int[ordered.length];
		for(int i=0;i<ordered.length;i++) {
			String carNum = ordered[i];
			Queue<String> timeQueue = timeMap.get(carNum);
			while(timeQueue.peek()!=null) {
				String in = timeQueue.poll();
				String out= null;
				if(!timeQueue.isEmpty()) {
					out = timeQueue.poll();
				}else {
					out="23:59";
				}
				timeElapsed[i]+=calcMinDiff(in, out);
				System.out.println(carNum);
				System.out.println(timeElapsed[i]);
			}
		}
		int[] result = new int[ordered.length];
		for(int i=0;i<timeElapsed.length;i++) {
			int time = timeElapsed[i];
			if(time<=baseTime) {
				result[i]=basePrice;
				continue;
			}
			time-=baseTime;
			int addPrice = (int)Math.ceil((double)time/unitTime)*unitPrice;
					
			
			result[i] = basePrice+addPrice;
		}		
		return result;
	}
	
	// 12:30 이런식으로 받을 것
	public int calcMinDiff(String in, String out) {
		String[] it= in.split(":");
		String[] ot= out.split(":");
		int inTime = Integer.parseInt(it[0])*60 + Integer.parseInt(it[1]);
		int outTime = Integer.parseInt(ot[0])*60 + Integer.parseInt(ot[1]);
		return outTime-inTime;
	}
	
	
	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		
		
		
		
		new Question_3().solution(fees, records);
	}
}
