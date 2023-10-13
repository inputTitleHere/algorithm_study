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
        if (step == n) {
            point = Math.max(point, score);
            return;
        }
        int k = order[step][0];
        int c = order[step][1];
//        System.out.println("k = " + k + "c = " + c);
        if (c == 0) {
            for (int i = 0; i < 4; i++) {
                int[][] newBoard = snapshot(board[mode]);
//                System.out.println("k = " + k + "c(i) = " + i);
                int localScore = score;
                board[mode] = newBoard;
                placeBlock(k, i, board[mode]);
//                System.out.println("_+_+_+_+_+_+_+");
//                printBoard(board[mode]);
                localScore += checkRow(board[mode]);
                gravitate(board[mode]);
                moveBlock(board, mode);
                mode = (mode + 1) % 2;
                gravitate(board[mode]);
                localScore += checkRow(board[mode]);
                dfs(step + 1, board, mode, localScore);
            }
        } else {
            int localScore = score;
            placeBlock(k, c - 1, board[mode]);
//            System.out.println("=========================================");
//            printBoard(board[mode]);

//            System.out.println("+++CHECK ROW");
            localScore += checkRow(board[mode]);
//            printBoard(board[mode]);

//            System.out.println("+++ GRAVITATE");
            gravitate(board[mode]);
//            printBoard(board[mode]);

//            System.out.println("+++ MOVEEEEE");
            moveBlock(board, mode);
            mode = (mode + 1) % 2;
//            printBoard(board[mode]);

//            System.out.println("+++ GRAVITATE 2");
            gravitate(board[mode]);
//            printBoard(board[mode]);

//            System.out.println("+++ CHECK ROW 2");
            localScore += checkRow(board[mode]);
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

    static void moveBlock(int[][][] board, int mode) {
        int[][] ori = board[mode];
        int[][] cpy = board[(mode + 1) % 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                int no = ori[i][j];
                if (no != 0) {
//                    System.out.println("HEEEEEEEEEEEEEEEEELP no = "+no);
                    for (int k : moveReference[no]) {
                        int[] move = direction[k - 1];
//                        System.out.print(Arrays.toString(move));
                        int ni = i + move[0];
                        int nj = j + move[1];
                        if (ni > -1 && ni < 4 && nj > -1 && nj < 4) {
//                            System.out.println("\nmovable = " + k + " of => " + Arrays.toString(move));
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
        board[mode] = new int[n + 1][4];
    }
}
