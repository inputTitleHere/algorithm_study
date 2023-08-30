package baekjoon.silver.three;

import java.io.*;

public class BJ_3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int mode = 0; // 미정 0, java식 1, c++식 2
        boolean isCpp = input.contains("_");
        char first = input.charAt(0);
        if(first=='_' || ('A'<= first && first<='Z')){
            System.out.println("Error!");
            return;
        }

        try {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if ('A' <= c && c <= 'Z') {
                    if (isCpp) throw new Exception();
                    sb.append('_').append(Character.toLowerCase(c));
                }
                else if (c == '_') {
                    char next = input.charAt(++i);
                    if('a'<=next && next<='z'){
                        sb.append(Character.toUpperCase(next));
                    }else{
                        throw new Exception();
                    }
                }
                else{
                    sb.append(c);
                }
            }
        } catch (Exception e) {
            System.out.println("Error!");
            return;
        }
        System.out.println(sb.toString());
    }
}

