package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_10845 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk;
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			stk = new StringTokenizer(br.readLine());
			switch(stk.nextToken()) {
			case "push" :
				que.add(Integer.parseInt(stk.nextToken()));
				break;
			case "pop" :
				if(!que.isEmpty()) {
					bw.write(Integer.toString(que.poll()));
					bw.write("\n");
				}else {
					bw.write("-1\n");
				}
				break;
			case "size" :
				bw.write(Integer.toString(que.size()));
				bw.write("\n");
				break;
			case "empty":
				if(que.isEmpty()) {
					bw.write("1\n");
				}else {
					bw.write("0\n");
				}
				break;
			case "front" :
				if(!que.isEmpty()) {
					bw.write(Integer.toString(que.peekFirst()));
					bw.write("\n");
				}else {
					bw.write("-1\n");	
				}
				break;
			case "back":
				if(!que.isEmpty()) {
					bw.write(Integer.toString(que.peekLast()));
					bw.write("\n");
				}else {
					bw.write("-1\n");
				}
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
