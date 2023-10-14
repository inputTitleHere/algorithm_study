package baekjoon.gold.four;

import java.io.*;
import java.util.*;

public class BJ_17140 {

    static int rlen = 3;
    static int clen = 3;
    static boolean isFlipped = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int r, c, k;
        stk = new StringTokenizer(br.readLine());
        r = Integer.parseInt(stk.nextToken()) - 1;
        c = Integer.parseInt(stk.nextToken()) - 1;
        k = Integer.parseInt(stk.nextToken());

        int[][] b = new int[3][3];
        for (int i = 0; i < 3; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                b[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int moves = 0;
        while (moves <= 100) {
//            System.out.println("MOVE : " + moves+ " T = "+isFlipped);
//            print(b);
            if (((b.length > r && b[0].length > c) && (!isFlipped && b[r][c] == k)) || ((b.length > c && b[0].length > r) && (isFlipped && b[c][r] == k))) {
                System.out.println(moves);
                return;
            }
            b = sortify(b);
            moves++;
        }
        System.out.println(-1);
    }

    static void print(int[][] b) {
        System.out.println("+===+");
        for (int[] arr : b) {
            System.out.println(Arrays.toString(arr));
        }
    }

    static int[][] sortify(int[][] b) {
        int maxlen = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int[] lane : b) {
            Map<Integer, N> m = new HashMap<>();
            for (Integer i : lane) {
                if (i == 0) {
                    continue;
                }
                if (m.containsKey(i)) {
                    m.get(i).cnt++;
                } else {
                    m.put(i, new N(i, 1));
                }
            }
            Set<N> s = new TreeSet<>(m.values());
            ArrayList<Integer> r = new ArrayList<>();
            for (N n : s) {
                if (r.size() == 100) {
                    break;
                }
                r.add(n.n);
                r.add(n.cnt);
            }
            maxlen = Math.max(maxlen, r.size());
            result.add(r);
        }
        for (List<Integer> lane : result) {
            while (lane.size() <= maxlen) {
                lane.add(0);
            }
        }
        // Transpose if needed
        int[][] resArr;
        if (result.size() < maxlen || (result.size() == maxlen && isFlipped)) { // Transpose
            resArr = new int[maxlen][result.size()];
            for (int i = 0; i < maxlen; i++) {
                for (int j = 0; j < result.size(); j++) {
                    resArr[i][j] = result.get(j).get(i);
                }
            }
            isFlipped = !isFlipped;
        } else {
            resArr = new int[result.size()][maxlen];
            for (int i = 0; i < result.size(); i++) {
                for (int j = 0; j < maxlen; j++) {
                    resArr[i][j] = result.get(i).get(j);
                }
            }
        }
        return resArr;
    }

    private static class N implements Comparable<N> {
        Integer n;
        int cnt;

        @Override
        public int hashCode() {
            return this.n;
        }

        public N(int n, int c) {
            this.n = n;
            this.cnt = c;
        }

        @Override
        public int compareTo(N n) {
            if (this.cnt == n.cnt) {
                return this.n - n.n;
            }
            return this.cnt - n.cnt;
        }
    }

}
