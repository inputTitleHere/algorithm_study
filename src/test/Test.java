package test;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		
		int[][][] board = new int[5][5][5];
		int n = 0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				for(int k=0;k<5;k++) {
					board[i][j][k]= n++;
				}
			}
		}
	}
}
