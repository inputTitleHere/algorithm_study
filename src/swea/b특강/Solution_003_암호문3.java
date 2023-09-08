package swea.b특강;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_003_암호문3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			List<String> secret = new LinkedList<String>();
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				secret.add(stk.nextToken());
			}
			int m = Integer.parseInt(br.readLine());
			// all orders
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				char type = stk.nextToken().charAt(0);
				switch(type) {
				case 'I':
					int pos = Integer.parseInt(stk.nextToken());
					int count = Integer.parseInt(stk.nextToken());
					List<String> insert = new LinkedList<>();
					for(int j=0;j<count;j++) {
						insert.add(stk.nextToken());
					}
					secret.addAll(pos, insert);
					break;
				case 'A':
					int AddCount = Integer.parseInt(stk.nextToken());
					for(int j=0;j<AddCount;j++) {
						secret.add(stk.nextToken());
					}
					break;
				case 'D':
					int deletePos = Integer.parseInt(stk.nextToken());
					int deleteCount = Integer.parseInt(stk.nextToken());
					for(int j=0;j<deleteCount;j++) {
						secret.remove(deletePos);
					}
				}
			}
			for(int i=0;i<10;i++) {
				sb.append(secret.get(i)).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
