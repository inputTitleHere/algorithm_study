package programmers.kakao.recruitment2023;

public class Q2 {

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {

		int dp = n-1;
		int pp = n-1;
		long dist = 0;
		
		int dep = -1;
		int pep = -1;
		
		while(dp>-1 || pp>-1) {
			int locCap = cap;
			boolean dpflag = true;
			boolean ppflag = true;
			// dp먼저
			while(dp>-1) {
				if(dpflag) {
					if(deliveries[dp]!=0) {
						// 배달 endpoint설정
						dep=dp;
						dpflag=false;
					}else {
						dp--;
						continue;
					}
				}
				if(deliveries[dp]>locCap) {
					deliveries[dp]-=locCap;
					break;
				}else {
					locCap-=deliveries[dp];
					deliveries[dp]=0;
					dp--;
				}
			}
			locCap=cap;
			while(pp>-1) {
				if(ppflag) {
					if(pickups[pp]!=0) {
						// 배달 endpoint설정
						pep=pp;
						ppflag=false;
					}else {
						pp--;
						continue;
					}					
				}
				if(pickups[pp]>locCap) {
					pickups[pp]-=locCap;
					break;
				}else {
					locCap-=pickups[pp];
					pickups[pp]=0;
					pp--;
				}
			}
			if(dep>-1 || pep>-1) {
				dist+=(Math.max(dep, pep)+1)*2;				
			}
			
			dep=-1;
			pep=-1;
		}
		System.out.println("dist = "+dist);
		return dist;
	}

	public static void main(String[] args) {
//		int[] del = {1,0,2,0,1,0,2};
//		int[] pick = {0,2,0,1,0,2,0};
//		int[] del = {1,1,1,1};
//		int[] pick = {1,1,1,1};
		int[] del = {0,0,0,0};
		int[] pick = {0,0,0,0};
		new Q2().solution(1, 4, del, pick);

	}
}
