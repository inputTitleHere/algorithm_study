package baekjoon._contest.GEC_Cup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GEC_3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// northlondo : NLCS
		// branksomeh : BHA
		// koreainter : KIS
		// stjohnsbur : SJA
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("northlondo", "NLCS");
		map.put("branksomeh", "BHA");
		map.put("koreainter", "KIS");
		map.put("stjohnsbur", "SJA");
		
		char[] c = br.readLine().trim().toCharArray();
		
		for(int i=0;i<26;i++) {
			String s = new String(c);
			String r = null;
			if((r=map.get(s))!=null) {
				System.out.println(r);
				break;
			}
			
			for(int j=0;j<10;j++) {
				if(c[j]=='z') {
					c[j]='a';
				}else {
					c[j]=(char)(c[j]+1);
				}
			}
		}
	}
}
