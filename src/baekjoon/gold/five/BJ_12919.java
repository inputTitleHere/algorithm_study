package baekjoon.gold.five;

import java.util.*;
import java.io.*;

public class BJ_12919 {

    static int tlen;
    static int slen;
    static String s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // A를 추가.
        // B를 추가하고 뒤집기
        s = br.readLine().trim();
        String t = br.readLine().trim();

        slen = s.length()-1;
        tlen = t.length();
        char[] word = new char[tlen];
        for (int i = 0; i < tlen; i++) {
            word[i] = t.charAt(i);
        }
        if (dfs(tlen-1, word)) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    static boolean dfs(int cursor, char[] arr) {
//        System.out.println(arr);
        if (cursor == slen) {
            return s.equals(new String(arr).trim());
        }
        // if ends with A
        if (arr[cursor] == 'A') {
//            System.out.println("CHECK A");
            arr[cursor] = ' ';
            if (dfs(cursor - 1, arr)) {
                return true;
            }
            arr[cursor]='A';
        }
        // case B and FLIP
        if (arr[0] == 'B') {
//            System.out.println("CHECK B");
            char[] flipped = flip(cursor, arr);
            flipped[cursor] = ' ';
            return dfs(cursor - 1, flipped);
        }
        return false;
    }

    static char[] flip(int r, char[] arr) {
        char[] narr = cpy(arr);
        int l = 0;
        while (l < r) {
            char tmp = narr[l];
            narr[l] = narr[r];
            narr[r] = tmp;
            l++;
            r--;
        }
        return narr;
    }

    static char[] cpy(char[] arr) {
        char[] narr = new char[tlen];
        System.arraycopy(arr, 0, narr, 0, tlen);
        return narr;
    }

}
