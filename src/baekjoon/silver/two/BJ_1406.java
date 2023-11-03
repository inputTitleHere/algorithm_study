package baekjoon.silver.two;

import java.io.*;
import java.util.*;

public class BJ_1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        String input = br.readLine().trim();
        int m = Integer.parseInt(br.readLine());
        Node start = new Node(' ', null, null);
        Node cursor = start;
        for (char c : input.toCharArray()) {
            Node newNode = new Node(c, cursor, null);
            cursor.post = newNode;
            cursor = newNode;
        }
        Node end = new Node(' ', cursor, null);
        cursor.post = end;
        cursor = end;

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            char order = stk.nextToken().charAt(0);
            switch (order) {
                case 'L':
                    if (cursor.prev != null && cursor.prev.c!=' ') {
                        cursor = cursor.prev;
                    }
                    break;
                case 'D':
                    if (cursor.post != null) {
                        cursor = cursor.post;
                    }
                    break;
                case 'B':
                    if (cursor.prev != null && cursor.prev.c != ' ') {
                        Node left = cursor.prev.prev;
                        Node prev = cursor.prev;

                        left.post = cursor;
                        cursor.prev = left;

                        prev.post = null;
                        prev.prev = null;
                    }
                    break;
                case 'P':
                    char newChar = stk.nextToken().charAt(0);
                    Node prev = cursor.prev;
                    Node newNode = new Node(newChar, prev, cursor);
                    prev.post = newNode;
                    cursor.prev = newNode;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (start.post != null) {
            sb.append(start.c);
            start=start.post;
        }
        System.out.println(sb.toString().trim());
    }

    private static class Node {
        char c;
        Node prev;
        Node post;

        public Node(char c, Node prev, Node post) {
            this.c = c;
            this.prev = prev;
            this.post = post;
        }
    }

}
