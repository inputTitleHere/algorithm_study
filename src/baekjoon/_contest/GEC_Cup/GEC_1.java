package baekjoon._contest.GEC_Cup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GEC_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("NLCS", "North London Collegiate School");
		map.put("BHA", "Branksome Hall Asia");
		map.put("KIS", "Korea International School");
		map.put("SJA", "St. Johnsbury Academy");
		
		System.out.println(map.get(input.trim()));
	}
}
