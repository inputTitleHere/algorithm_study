package baekjoon.gold.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10986 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    long[] s = new long[n+1];
    long[] rems = new long[m];

    long count=0;

    st=new StringTokenizer(br.readLine());
    s[0]=0;
    for(int i=1;i<=n;i++){
      s[i]=s[i-1]+Long.parseLong(st.nextToken());
    }
    for(int i=1;i<=n;i++){
      int remainder = (int)(s[i]%m);
      if(remainder==0) count++;
      rems[remainder]++;
    }
    for(int i=0;i<m;i++){
      if(rems[i]>1){
        count+=rems[i]*(rems[i]-1)/2;
      }
    }
    System.out.println(count);
	}
}
