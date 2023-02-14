package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_백승윤 {
	public static void main(String[] args) throws IOException{
		
		int star = '*';
		int div = '/';
		int add = '+';
		int sub = '-';
		int zero = '0';
		int nine = '9';
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk=null;
		TESTCASE : for(int t=1;t<=10;t++) {
			sb.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			if(n%2==0) {
				// 노드수가 짝수이면 나중에 연산짝이 안맞는다.
				sb.append(0).append("\n");
				for(int i=0;i<n;i++) { // 그냥 버린다.
					br.readLine();
				}
				continue TESTCASE;
			}
			for(int i=1;i<=n/2;i++) { // 여기는 연산자가 나와야 할 것.
				stk = new StringTokenizer(br.readLine());
				stk.nextToken(); // 위치정보 필요없을듯...
				int nextChar = stk.nextToken().codePointAt(0);
				if(!(nextChar == star || nextChar == div || nextChar == add || nextChar == sub)) {
					sb.append(0).append("\n");
					// 나머지 문자열 버리기
					for(int j=i;j<n;j++) {
						br.readLine();
					}
					continue TESTCASE;
				}
			}
			for(int i=n/2+1;i<=n;i++) {
				stk = new StringTokenizer(br.readLine());
				stk.nextToken();
				int nextChar = stk.nextToken().codePointAt(0);
				if(nextChar < zero || nextChar > nine) {
					sb.append(0).append("\n");
					// 나머지 문자열 버리기
					for(int j=i;j<n;j++) {
						br.readLine();
					}
					continue TESTCASE;
				}
			}
			sb.append(1).append("\n");
		}
		System.out.println(sb.toString());
	}
}

// case -> 리프가 아닌데 숫자가 오는 경우 = 0
// case -> 리프인데 연산자가 오는 경우 = 0
// case -> 연산짝이 안맞는 경우(총 노드수가 짝수인 경우)
