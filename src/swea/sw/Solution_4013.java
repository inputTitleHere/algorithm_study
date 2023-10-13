package swea.sw;

import java.io.*;
import java.util.*;

public class Solution_4013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = 0, t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        while (tcase++ < t) {
            sb.append("#").append(tcase).append(" ");
            int k = Integer.parseInt(br.readLine());
            ArrayList<LinkedList<Integer>> mag = new ArrayList<>(4);
            for (int i = 0; i < 4; i++) {
                stk = new StringTokenizer(br.readLine());
                LinkedList<Integer> m = new LinkedList<>();
                for (int j = 0; j < 8; j++) {
                    m.add(Integer.parseInt(stk.nextToken()));
                }
                mag.add(m);
            }
            for (int i = 0; i < k; i++) {
                stk = new StringTokenizer(br.readLine());
                int no = Integer.parseInt(stk.nextToken()) - 1;
                int dir = Integer.parseInt(stk.nextToken());
                Queue<int[]> orderQue = new ArrayDeque<>();
                Queue<int[]> searchQue = new ArrayDeque<>();
                searchQue.add(new int[]{no, dir});
                boolean[] vis = new boolean[4];
                vis[no] = true;
                while (!searchQue.isEmpty()) {
                    int[] moveable = searchQue.poll();
                    vis[moveable[0]] = true;
                    orderQue.add(moveable);
                    int left = moveable[0] - 1;
                    int right = moveable[0] + 1;
                    if (left >= 0 && !vis[left]) {
                        if (!mag.get(left).get(2).equals(mag.get(moveable[0]).get(6))) {
                            searchQue.add(new int[]{left, -moveable[1]});
                        }
                    }
                    if (right < 4 && !vis[right]) {
                        if (!mag.get(right).get(6).equals(mag.get(moveable[0]).get(2))) {
                            searchQue.add(new int[]{right, -moveable[1]});
                        }
                    }
                }
                while (!orderQue.isEmpty()) {
                    int[] order = orderQue.poll();
                    rotate(mag.get(order[0]), order[1] == 1);
                }
            }
            // check point
            int point = 0;
            for (int i = 0; i < 4; i++) {
                point += (1 << i) * mag.get(i).get(0);
            }
            sb.append(point).append("\n");
        }
        System.out.println(sb);
    }

    static void rotate(LinkedList<Integer> target, boolean isClockwise) {
        if (isClockwise) {
            target.addFirst(target.pollLast());
        } else {
            target.addLast(target.pollFirst());
        }
    }
}
