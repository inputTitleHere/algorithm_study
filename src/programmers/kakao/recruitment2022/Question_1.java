package programmers.kakao.recruitment2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question_1 {
	
    public int[] solution(String[] id_list, String[] report, int k) {
    	
    	Map<String, Set<String>> map = new HashMap<String, Set<String>>();
    	Map<String, Integer> resultCounter = new HashMap<String, Integer>();
    	for(String id : id_list) {
    		map.put(id, new HashSet<String>());
    		resultCounter.put(id, 0);
    	}
    	for(String r : report) {
    		String[] split = r.split(" ");
    		map.get(split[1]).add(split[0]);
    	}
    	for(String id : id_list) {
    		Set<String> reports = map.get(id);
    		if(reports.size()>=k) {
    			for(String name : reports) {
    				resultCounter.put(name, resultCounter.get(name)+1);
    			}
    		}
    	}
    	int[] resultArr = new int[id_list.length];
    	for(int i=0;i<id_list.length;i++) {
    		resultArr[i] = resultCounter.get(id_list[i]);
    	}
        
        return resultArr;
    }
	
	
	public static void main(String[] args) {
		
	}
	
}
