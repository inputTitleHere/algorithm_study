package baekjoon.silver.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Java 8  : 268ms
// Java 11 : 356ms
public class Main_16935_백승윤 {
	
	static int[][] board;
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken()); // n,m은 짝수
		m = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		
		int[][] localBoard = new int[n][m]; 
		for(int i=0;i<n;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				localBoard[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		board = localBoard;
		// 데이터 로드 끝
		stk = new StringTokenizer(br.readLine());
		for(int i=0;i<r;i++) {
			int order = Integer.parseInt(stk.nextToken());
			switch(order) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int[] iarr : board) {
			for(int i : iarr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void one() { // 상하반전
		int[] tmp;
		for(int i=0;i<n/2;i++) {
			tmp=board[i];
			board[i]=board[n-i-1];
			board[n-i-1]=tmp;
		}
	}
	
	static void two() { // 좌우반전
		int tmp;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m/2;j++) {// stack써도 되긴 할듯. 
				tmp=board[i][j];
				board[i][j]=board[i][m-j-1];
				board[i][m-j-1]=tmp;
			}
		}
	}
	
	static void three() { // 오른쪽 90 도 돌리기이이이이이이 -> 걍 하나하나 돌려
		int[][] tmp = new int[m][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tmp[j][n-i-1] = board[i][j];
			}
		}
		board = tmp;
		int itmp = n;
		n=m;
		m=itmp;
	}
	
	static void four() { // 왼쪽 90도
		int[][] tmp = new int[m][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tmp[m-j-1][i]=board[i][j];
			}
		}
		board = tmp;
		int itmp = n;
		n=m;
		m=itmp;
	}
	
	static void five() { // 4방위에 대한 시계이동
		int[][] tmp = new int[n][m];
		for(int i=0;i<n/2;i++) {
			System.arraycopy(board[i], 0, tmp[i], m/2, m/2); // 1->2
			System.arraycopy(board[i], m/2, tmp[n/2+i], m/2, m/2); // 2->3
			System.arraycopy(board[n-i-1], m/2, tmp[n-i-1], 0, m/2); // 3->4
			System.arraycopy(board[n/2+i], 0, tmp[i], 0, m/2); // 4->1
		}
		board = tmp;
	}
	static void six() { // 4방위에 대한 반시계 이동
		int[][] tmp = new int[n][m];
		for(int i=0;i<n/2;i++) {
			System.arraycopy(board[i], m/2, tmp[i],0 , m/2); // 2->1
			System.arraycopy(board[n/2+i], m/2, tmp[i], m/2, m/2); // 3->2
			System.arraycopy(board[n-i-1], 0, tmp[n-i-1], m/2, m/2); // 4->3
			System.arraycopy(board[i], 0, tmp[n/2+i], 0, m/2); // 1->4
		}
		board = tmp;
	}
}
