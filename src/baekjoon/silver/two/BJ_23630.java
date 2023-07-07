package baekjoon.silver.two;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_23630 {
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] bitCount = new int[32];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int next = Integer.parseInt(stk.nextToken());
            int pos = 0;
            while(next>0){
                if(next%2==1){
                    bitCount[pos]++;
                }
                next/=2;
                pos++;
           }
        }
        int maxCount = 0;
        for(int i=0;i<32;i++){
            if(bitCount[i]>maxCount){
                maxCount=bitCount[i];
            }
        }
        System.out.println(maxCount);
    }
}
