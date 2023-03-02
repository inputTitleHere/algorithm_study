package baekjoon.gold.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// java 11 : 416ms
// 힘들었...
public class Main_17143_백승윤 {

	static int[][] directions = { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int r;
	static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());

		Shark[][] pool = new Shark[r][c];

		for (int i = 0; i < m; i++) {
			Shark s = new Shark(br.readLine());
			pool[s.r][s.c] = s;
		}

		int fisherman = -1;
		int weight = 0;
		while (fisherman < c-1) {
			fisherman++; // 1. 우로한칸
			int pole = 0; // 2. 낚시
			Shark s = null;
			while (pole < r) {
				if (pool[pole][fisherman] != null) {
					s = pool[pole][fisherman];
					pool[pole][fisherman] = null;
					break;
				}
				pole++;
			}
			if (s != null) {
				weight += s.size;
			}
			// 3. 상어들 이동
//			System.out.println("Step : " + fisherman);
			pool = simulate(pool);
		}
		System.out.println(weight);
	}

	private static class Shark {
		int r; // 행
		int c; // 열
		int speed; // 속도
		int dir; // 방향 -> 1(위) 2(아래) 3(오른쪽) 4(왼쪽)
		int size; // 크기

		public Shark(String s) {
			StringTokenizer stk = new StringTokenizer(s);
			this.r = Integer.parseInt(stk.nextToken()) - 1;
			this.c = Integer.parseInt(stk.nextToken()) - 1;
			this.speed = Integer.parseInt(stk.nextToken());
			this.dir = Integer.parseInt(stk.nextToken());
			this.size = Integer.parseInt(stk.nextToken());
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", speed=" + speed + ", dir=" + dir + ", size=" + size + "]";
		}

	}

	static Shark[][] simulate(Shark[][] pool) {
		Shark[][] after = new Shark[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (pool[i][j] != null) {
					// 방향에 따라 행렬 이동 판단
					Shark s = pool[i][j];
					int spd = s.speed;
					if (s.dir == 1 || s.dir == 2) {
						spd = s.speed % ((r - 1) * 2);
						while (spd > 0) {
							if(s.dir==1) {
								if(s.r==0) {
									s.r=1;
									s.dir=2;
									spd--;
								}else {
									s.r--;
									spd--;
								}
							}else {
								if(s.r==r-1) {
									s.r=r-2;
									s.dir=1;
									spd--;
								}else {
									s.r++;
									spd--;
								}
							}
						}
					} else {
						spd = s.speed % ((c - 1) * 2);
						while (spd > 0) {
							if(s.dir==3) {
								if(s.c==c-1) {
									s.c=c-2;
									s.dir=4;
									spd--;
								}else {
									s.c++;
									spd--;
								}
							}else {
								if(s.c==0) {
									s.c=1;
									s.dir=3;
									spd--;
								}else {
									s.c--;
									spd--;
								}
							}
						}
					}
//					System.out.println(s.toString());
					if(after[s.r][s.c]!=null) {
						Shark prev = after[s.r][s.c];
						if(prev.size<s.size) {
							after[s.r][s.c] = s;							
						}
					}else {
						after[s.r][s.c] = s;							
					}
				}
			}
		}
		return after;
	}

}
