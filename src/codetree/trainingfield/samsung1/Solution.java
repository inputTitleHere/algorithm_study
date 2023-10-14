package codetree.trainingfield.samsung1;

import java.io.*;
import java.util.*;

// 신기한 버켓토
public class Solution {

    static int point = 0;
    static int n = 0;
    static int[][] direction = { // [y,x]
            {1, 0},
            {1, -1},
            {0, -1},
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, 1},
            {1, 1}
    };
    static int[][] moveReference = new int[9][8];
    static int[][] order = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        n = Integer.parseInt(br.readLine());
        order = new int[n][2];
        for (int i = 1; i <= 8; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                moveReference[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            order[i][0] = k;
            order[i][1] = c;
        }
        dfs(0, new int[2][n + 1][4], 0, 0);
        System.out.println(point);
    }

    static void printBoard(int[][] board) {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    // board[버전][행][열]
    static void dfs(int step, int[][][] board, int mode, int score) {
//        System.out.println("s >> " + step + " mode >> " + mode);
        if (step == n) {
//            System.out.println("ITS OVER ANAKIN! I HAVE THE HIGH GROUND!!");
//            printBoard(board[mode]);
            point = Math.max(point, score);
//            System.out.println("SCORE = " + score);
            return;
        }
        int k = order[step][0];
        int c = order[step][1];
//        System.out.println("k = " + k + "c = " + c);
        if (c == 0) { // 무작위 배치인 경우
            for (int i = 0; i < 4; i++) {
                int[][] newBoard = snapshot(board[mode]);
//                System.out.println("k = " + k + "c(i) = " + i);
//                System.out.println("BEFORE+++++++++++++");
//                printBoard(board[mode]);
                int localScore = score;
                placeBlock(k, i, board[mode]);
                localScore += checkRow(board[mode]);
                gravitate(board[mode]);
                moveBlock(board, mode);
                mode = (mode + 1) % 2;
                gravitate(board[mode]);
                localScore += checkRow(board[mode]);
                gravitate(board[mode]);
//                System.out.println("AFTER+++++++++++++");
//                printBoard(board[mode]);
                dfs(step + 1, board, mode, localScore);
                // remove last placed block
                board[mode] = newBoard;


            }
        } else { // 지정배치인경우
            int localScore = score;
            placeBlock(k, c - 1, board[mode]);
//            System.out.println("=========================================");
//            printBoard(board[mode]);

            localScore += checkRow(board[mode]);
//            System.out.println("+++CHECK ROW");
//            printBoard(board[mode]);

            gravitate(board[mode]);
//            System.out.println("+++ GRAVITATE");
//            printBoard(board[mode]);

            moveBlock(board, mode);
            mode = (mode + 1) % 2;
//            System.out.println("+++ MOVEEEEE");
//            printBoard(board[mode]);

            gravitate(board[mode]);
//            System.out.println("+++ GRAVITATE 2");
//            printBoard(board[mode]);

//            System.out.println("+++ CHECK ROW 2");
            localScore += checkRow(board[mode]);

            gravitate(board[mode]);

            dfs(step + 1, board, mode, localScore);
        }
    }

    static int[][] snapshot(int[][] board) {
        int[][] newBoard = new int[n][];
        for (int i = 0; i < n; i++) {
            newBoard[i] = Arrays.copyOf(board[i], 4);
        }
        return newBoard;
    }

    static void placeBlock(int k, int c, int[][] board) {
        for (int i = 0; i < n; i++) {
            if (board[i][c] == 0) {
                board[i][c] = k;
                break;
            }
        }
    }

    static int checkRow(int[][] board) {
        int pnt = 0;
        LOOP:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) {
                    break LOOP;
                }
            }
            pnt++;
            Arrays.fill(board[i], 0);
        }
        return pnt;
    }

    static void gravitate(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < n; j++) {
                if (board[j][i] != 0) {
                    int k = j;
                    while (k > 0 && board[k - 1][i] == 0) {
                        k--;
                    }
                    if (k != j) {
                        board[k][i] = board[j][i];
                        board[j][i] = 0;
                    }
                }
            }
        }
    }

    // 규칙에 따라 블럭 옮기기
    static void moveBlock(int[][][] board, int mode) {
        int[][] ori = board[mode];
        int[][] cpy = new int[board[mode].length][board[mode][0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                int no = ori[i][j];
                if (no != 0) {
                    for (int k : moveReference[no]) {
                        int[] move = direction[k - 1];
                        int ni = i + move[0];
                        int nj = j + move[1];
                        if (ni > -1 && ni < n && nj > -1 && nj < 4) {
                            if (cpy[ni][nj] != 0) {
                                cpy[ni][nj] = Math.min(cpy[ni][nj], ori[i][j]);
                            } else {
                                cpy[ni][nj] = ori[i][j];
                            }
                            break;
                        }
                    }
                }
            }
        }
        board[(mode + 1) % 2] = cpy;
        board[mode] = new int[n + 1][4];
    }
}
