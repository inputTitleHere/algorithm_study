package baekjoon.gold.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_7588 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int input = Integer.parseInt(br.readLine());
			if(input==0) {
				break;
			}
			sb.append("\n");
			sb.append("Amicable numbers between 1 and ").append(input).append("\n");
			int[] sum = new int[input+1];
			for(int i=1;i<=input;i++) {
				sum[i]=getDivisorSum(i);
			}
			// check for pairs
			int cnt=0;
			for(int i=1;i<=input;i++) {
				if(sum[i]==-1) {
					continue;
				}
				if(sum[i]<=input && sum[sum[i]]==i && !(sum[i]==i)) { // 조건 todo
					cnt++;
					sb.append(i).append(" ").append(sum[i]).append("\n");
					sum[i]=-1;
				}
			}
			
			if(cnt==0) {
				sb.append("None\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	static int getDivisorSum(int number){
		int root = (int)Math.sqrt(number);
		int sum=0;
		for(int i=2;i<=root;i++) {
			if(number%i==0) {
				int mirror = number/i;
				if(mirror!=i) {
					sum+=i+mirror;
				}else {
					sum+=i;
				}
			}
		}
		return sum+1; // 1도 약수지만 대비되는 숫자 자체는 포함하지 않는다.
	}
}
