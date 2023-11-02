package baekjoon.silver.three;

import java.util.*;
import java.io.*;

public class BJ_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            String title = stk.nextToken();
            int value = Integer.parseInt(stk.nextToken());
            if (!map.containsKey(value)) {
                map.put(value, title);
            }
        }
        List<Integer> powers = new ArrayList<>(map.keySet());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            int next = Integer.parseInt(br.readLine());
            sb.append(map.get(binarySearch(next,powers))).append("\n");
        }
        System.out.println(sb);
    }

    static int binarySearch(int target, List<Integer> powers) {
        int l = 0, r = powers.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int compTgt = powers.get(mid);
            if (compTgt < target) {
                l = mid+1;
            } else if (compTgt > target) {
                r = mid;
            } else {
                return compTgt;
            }
        }
        return powers.get(l);
    }
}
