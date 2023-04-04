package baekjoon.gold.four;

import java.io.*;

public class BJ_5052 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		TC : for(int tc=0;tc<t;tc++) {
			int n = Integer.parseInt(br.readLine());
			char[][] phonebook = new char[n][10];
			int[] lenTable = new int[n];
			int[][] hashTable = new int[n][10];
			for(int i=0;i<n;i++) {
				char[] next = br.readLine().toCharArray();
				lenTable[i]=next.length-1;
				int ptr=0;
				int hash=0;
				for(char c : next) {
					hash=hash*31+(c-'0');
					phonebook[i][ptr]=c;
					hashTable[i][ptr]=hash;
					ptr++;
				}
			}
			for(int i=0;i<n;i++) {
				CHECK : for(int j=i+1;j<n;j++) {
					int len;
					if(lenTable[i]<lenTable[j]) {
						len=lenTable[i];
					}else if(lenTable[i]>lenTable[j]) {
						len=lenTable[j];
					}else {
						continue;
					}
					if(hashTable[j][len]==hashTable[i][len]) {
						// do check
						for(int k=0;k<len;k++) {
							if(phonebook[i][k]!=phonebook[j][k]) {
								continue CHECK;
							}
						}
						sb.append("NO\n");
						continue TC;
					}
				}
			}
			sb.append("YES\n");
		}
		System.out.println(sb.toString());
	}
}
