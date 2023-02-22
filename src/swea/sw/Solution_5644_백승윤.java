package swea.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 128ms
public class Solution_5644_백승윤 {
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int chargers;
	static Battery[] battPower;
	// x, y 순서
	static int[][] ctrl = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			stk = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(stk.nextToken()); // 시간
			chargers = Integer.parseInt(stk.nextToken()); // 충전소 개수

			map = new int[11][11];

			stk = new StringTokenizer(br.readLine());
			StringTokenizer stk2 = new StringTokenizer(br.readLine());
			int[] amove = new int[time + 1];
			int[] bmove = new int[time + 1];
			for (int i = 1; i <= time; i++) {
				amove[i] = Integer.parseInt(stk.nextToken());
				bmove[i] = Integer.parseInt(stk2.nextToken());
			}
			battPower = new Battery[chargers]; // power적어두기
			for (int c = 0; c < chargers; c++) {
				stk = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				int range = Integer.parseInt(stk.nextToken());
				int power = Integer.parseInt(stk.nextToken());
				battPower[c] = new Battery(c, power);

				// 파워 필드 기록하기
				for (int i = Math.max(1, y - range); i <= Math.min(10, y + range); i++) {
					for (int j = Math.max(1, x - range); j <= Math.min(10, x + range); j++) {
						if (Math.abs(i - y) + Math.abs(j - x) <= range) {
							map[i][j] |= 1 << c; // 에베베벱
						}
					}
				}
			}
			
			// 탐험시작
			Pos a = new Pos(1, 1);
			Pos b = new Pos(10, 10);

			int total=0;
			
			for (int i = 0; i <= time; i++) {
				a.x += ctrl[amove[i]][0];
				a.y += ctrl[amove[i]][1];

				b.x += ctrl[bmove[i]][0];
				b.y += ctrl[bmove[i]][1];

				// getCollision
				PriorityQueue<Battery> acoll = getCollision(a);
				PriorityQueue<Battery> bcoll = getCollision(b);
				// 판다아아아안
				if (acoll != null && bcoll != null) { // 둘다 뭐라도 밟고 있을 때
					Battery abat = acoll.poll();
					Battery bbat = bcoll.poll();
					if (abat.equals(bbat)) { // 같은 최고 영역에 있을 때
						Battery anext = acoll.poll(); // 없으면 null반환
						Battery bnext = bcoll.poll();
						if (anext!=null && bnext!=null) { // a,b둘다 뭔가 더 있는 경우
							Battery bigger = anext.power > bnext.power ? anext : bnext;
							total+=bigger.power + abat.power; // 어째피 최초 a,b는 같음
						}else if (anext!=null) { // a가 뭔가 더 있는 경우 (둘다 null 아닌건 이미 위에서 처리됨)
							total+=bbat.power+anext.power;
						}else if (bnext!=null) { // b에 뭐 있음
							total+=abat.power+bnext.power;
						}else { // 깡 같은 영역 겹침.
							total+=abat.power; // 어째피 반띵하는거 하나만 더하기
						}
					}else{ // 서로 다른 최고 영역 -> 둘다 더하기
						total +=abat.power+bbat.power;
					}
				} else if(acoll!=null) { // a만 충전칸에 있는 경우
					total+=acoll.poll().power;
				} else if(bcoll!=null) { // b만 충전칸에 있는 경우
					total+=bcoll.poll().power;
				} // 둘다 충전칸 밖이면 암것도 충전 안됨.
			}
			sb.append("#").append(t).append(" ").append(total).append("\n");
		}
		System.out.println(sb.toString());
	}

	static PriorityQueue<Battery> getCollision(Pos of) {
		int field = map[of.y][of.x];
		if (field == 0)
			return null;
		PriorityQueue<Battery> pq = new PriorityQueue<>();
		for (int i = 0; i < chargers; i++) {
			if ((field & 1 << i) != 0) {
				pq.add(battPower[i]);
			}
		}
		return pq;
	}

	private static class Battery implements Comparable<Battery> {
		int no;
		int power;

		public Battery(int no, int power) {
			this.no = no;
			this.power = power;
		}

		@Override
		public int compareTo(Battery o) {
			return o.power - this.power; // 내림차순
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + no;
			result = prime * result + power;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Battery other = (Battery) obj;
			if (no != other.no)
				return false;
			if (power != other.power)
				return false;
			return true;
		}
	}

	private static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
	}
}
