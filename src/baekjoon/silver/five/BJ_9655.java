package baekjoon.silver.five;


import java.io.*;

public class BJ_9655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) % 2; // even = c, odd = s
        System.out.println(n==0?"CY":"SK");
    }
}
