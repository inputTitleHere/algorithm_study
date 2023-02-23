package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_백승윤 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		int tc = Integer.parseInt(br.readLine());
		int[][] ctrl = {
				{0,-1}, // U
				{1,0}, // R
				{0,1}, // D
				{-1,0}, // L
		};// U,L,D,R,S
		char[] tankShape = {'^','>','v','<'};
		
		for(int t=1;t<=tc;t++) {
			sb.append("#").append(t).append(" ");
			stk = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			
			int x=0;
			int y=0;
			Act dir = null;
			
			char[][] map = new char[h][w];
			// 맵 로드
			for(int i=0;i<h;i++) {
				char[] carr = br.readLine().toCharArray();
				for(int j=0;j<w;j++) {
					char c = carr[j];
					map[i][j]=c;
					if(c=='<'){
						x=j;
						y=i;
						dir=Act.L;
					}else if (c=='>') {
						x=j;
						y=i;
						dir=Act.R;
					}else if (c=='^') {
						x=j;
						y=i;
						dir = Act.U;
					}else if (c=='v') {
						x=j;
						y=i;
						dir = Act.D;
					}
				}
			}// 맵 로드 끝
			int m = Integer.parseInt(br.readLine());
			String orders = br.readLine();
			for(int i=0;i<m;i++) { // 이동시뮬
				Act next = Act.valueOf(Character.toString(orders.charAt(i)));
				if(next==Act.S) { // 쏘기
					int facing = dir.ordinal();
					int bx = x+ctrl[facing][0];
					int by = y+ctrl[facing][1];
					while(bx>=0 && bx<w && by >=0 && by<h) {
						if(map[by][bx]=='*') {
							map[by][bx]='.';
							break;
						}
						if(map[by][bx]=='#') {
							break;
						}
						bx+=ctrl[facing][0];
						by+=ctrl[facing][1];
					}
				}else { // 움직이기
					int move = next.ordinal();
					int nx = x+ctrl[move][0];
					int ny = y+ctrl[move][1];
					// 박스 안인지 확인
					dir=next; // 방향은 바꿀 수 있음
					if(nx<0 || nx>=w || ny<0 || ny>=h || map[ny][nx]!='.') { // 못가는 곳일 때
						// 생긴거 바꾸기
						map[y][x]=tankShape[move];
						continue;
					}
					// 이동
					map[y][x]='.';
					map[ny][nx] = tankShape[move];
					x=nx;
					y=ny;
				}
			} // 이동 시뮬 끝
			
			// 출력하기
			for(char[] carr : map) {
				for(char ch : carr) {
					sb.append(ch);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	private static enum Act{
		U,R,D,L,S
	}
}
