package codetree.trainingfield.samsung1;

import java.io.*;
import java.util.*;

public class Robots {

    static int l, n, q;
    static int[][] map;
    static int[][] placement;
    static Robot[] robots;

    static boolean[] vis;

    static Stack<Integer> moveStack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        l = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        q = Integer.parseInt(stk.nextToken());
        map = new int[l][l];
        placement = new int[l][l];
        for (int i = 0; i < l; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < l; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        robots = new Robot[n + 1];
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stk.nextToken()) - 1;
            int c = Integer.parseInt(stk.nextToken()) - 1;
            int h = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());
            robots[i] = new Robot(r, c, h, w, k);
            for (int rloc = r; rloc < r + h; rloc++) {
                for (int cloc = c; cloc < c + w; cloc++) {
                    placement[rloc][cloc] = i;
                    if (map[rloc][cloc] == 1) {
                        robots[i].trapCount++;
                    }
                }
            }
        }
        moveStack = new Stack<>();
//        print(placement);
        for (int i = 0; i < q; i++) {
            stk = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(stk.nextToken());
            int dir = Integer.parseInt(stk.nextToken()); // 0(up), 1(right), 2(down), 3(left)
//            System.out.println("Order no = " + i + " id = " + id + " dir = " + dir);
            if (checkMovable(id, dir)) {
//                System.out.println("MOVEABLE");
//                System.out.println(moveStack);
                moveAll(id, dir);
                calculateDamage(id);
            }
//            print(placement);
            moveStack.clear();
        }
        int damageTotal = 0;
        for (int i = 1; i <= n; i++) {
            Robot bot = robots[i];
            if (!bot.isDestroyed) {
                damageTotal += bot.damage;
            }
        }
        System.out.println(damageTotal);
    }

    static void print(int[][] target) {
        System.out.println("-------------");
        for (int i = 0; i < l; i++) {
            System.out.print("[");
            for (int j = 0; j < l; j++) {
                System.out.printf("%2d ", target[i][j]);
            }
            System.out.println("]");
        }
    }

    static void calculateDamage(int except) {
        for (int i = 0; i <= n; i++) {
            if (vis[i] && i != except) {
                Robot bot = robots[i];
                if (!bot.isDestroyed) {
                    bot.damage += bot.trapCount;
                    if (bot.damage >= bot.k) {
                        bot.isDestroyed = true;
                        bot.damage = 0;
                        destroy(i);
                    }
                }
            }
        }
    }

    static void destroy(int target) {
        Robot bot = robots[target];
        for (int i = bot.r; i < bot.r + bot.h; i++) {
            for (int j = bot.c; j < bot.c + bot.w; j++) {
                placement[i][j] = 0;
            }
        }
    }


    static void moveAll(int starter, int dir) {
        while (!moveStack.isEmpty()) {
            int next = moveStack.pop();
            int head, tail;
            Robot bot = robots[next];
            switch (dir) {
                case 0: // up
                    head = bot.r - 1;
                    tail = bot.r + bot.h - 1;
                    for (int i = bot.c; i < bot.c + bot.w; i++) {
                        placement[head][i] = next;
                        if (map[head][i] == 1) bot.trapCount++;
                        placement[tail][i] = 0;
                        if (map[tail][i] == 1) bot.trapCount--;
                    }
                    bot.r--;
                    break;
                case 1: // right
                    head = bot.c + bot.w;
                    tail = bot.c;
                    for (int i = bot.r; i < bot.r + bot.h; i++) {
                        placement[i][head] = next;
                        if (map[i][head] == 1) bot.trapCount++;
                        placement[i][tail] = 0;
                        if (map[i][tail] == 1) bot.trapCount--;
                    }
                    bot.c++;
                    break;
                case 2: // down
                    head = bot.r + bot.h;
                    tail = bot.r;
                    for (int i = bot.c; i < bot.c + bot.w; i++) {
                        placement[head][i] = next;
                        if (map[head][i] == 1) bot.trapCount++;
                        placement[tail][i] = 0;
                        if (map[tail][i] == 1) bot.trapCount--;
                    }
                    bot.r++;
                    break;
                case 3: // left
                    head = bot.c - 1;
                    tail = bot.c + bot.w - 1;
                    for (int i = bot.r; i < bot.r + bot.h; i++) {
                        placement[i][head] = next;
                        if (map[i][head] == 1) bot.trapCount++;
                        placement[i][tail] = 0;
                        if (map[i][tail] == 1) bot.trapCount--;
                    }
                    bot.c--;
                    break;
            }
        }
    }

    static boolean checkMovable(int id, int dir) {
        Robot bot = robots[id];
        if(bot.isDestroyed){
            return false;
        }
        Queue<Integer> que = new ArrayDeque<>();
        vis = new boolean[n + 1];
        vis[id] = true;
        que.offer(id);
        moveStack.add(id);
        int ny, nx, ne;
        while (!que.isEmpty()) {
            Set<Integer> adjSet = new HashSet<>();
            Robot next = robots[que.poll()];
            switch (dir) {
                case 0: // up
                    if (next.r == 0) return false;
                    ny = next.r - 1;
                    for (int i = next.c; i < next.c + next.w; i++) {
                        if (map[ny][i] == 2) return false;
                        ne = placement[ny][i];
                        if (ne != 0 && !vis[ne]) {
                            vis[ne] = true;
                            adjSet.add(ne);
                        }
                    }
                    break;
                case 1: // right
                    if (next.c + next.w == l) return false;
                    nx = next.c + next.w;
                    for (int i = next.r; i < next.r + next.h; i++) {
                        if (map[i][nx] == 2) return false;
                        ne = placement[i][nx];
                        if (ne != 0 && !vis[ne]) {
                            vis[ne] = true;
                            adjSet.add(ne);
                        }
                    }
                    break;
                case 2: // down
                    if (next.r + next.h == l) return false;
                    ny = next.r + next.h;
                    for (int i = next.c; i < next.c + next.w; i++) {
                        if (map[ny][i] == 2) return false;
                        ne = placement[ny][i];
                        if (ne != 0 && !vis[ne]) {
                            vis[ne] = true;
                            adjSet.add(ne);
                        }
                    }
                    break;
                case 3: // left
                    if (next.c == 0) return false;
                    nx = next.c - 1;
                    for (int i = next.r; i < next.r + next.h; i++) {
                        if (map[i][nx] == 2) return false;
                        ne = placement[i][nx];
                        if (ne != 0 && !vis[ne]) {
                            vis[ne] = true;
                            adjSet.add(ne);
                        }
                    }
                    break;
            }
            que.addAll(adjSet);
            moveStack.addAll(adjSet);
        }

        return true;
    }

    static class Robot {
        int r;
        int c;
        int h;
        int w;
        int k;
        int damage;
        boolean isDestroyed;
        int trapCount;

        public Robot(int r, int c, int h, int w, int k) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.k = k;
            this.isDestroyed = false;
            this.damage = 0;
            this.trapCount = 0;
        }

    }

}
