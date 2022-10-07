package baekjoon.silver.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11659 {
	public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st=new StringTokenizer(br.readLine());
    int[] s = new int[n+1];
    for(int i=1;i<=n;i++){
      s[i]=s[i-1]+Integer.parseInt(st.nextToken());
    }

    for(int j=0;j<m;j++){ // 양쪽 다 inclusive
      st=new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      sb.append(s[end]-s[start-1]+"\n");
    }
    System.out.println(sb);
	}
}
