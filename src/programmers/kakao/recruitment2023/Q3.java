package programmers.kakao.recruitment2023;

import java.util.Arrays;

public class Q3 {
	
    public int[] solution(int[][] users, int[] emoticons) {
    	Arrays.sort(emoticons);
    	int items = emoticons.length;
    	// 초기 40% 일괄할인
    	// d = discount
    	int[] d= new int[items];
    	Arrays.fill(d, 40);
    	int discP=0;
    	
    	int plus = 0;
    	int totalBought = Integer.MIN_VALUE;
    	
    		
    	boolean flag = true;
    	while(flag) {
    		int localPlus=0;
    		int localBought=0;
    		// 유저마다
    		for(int[] user : users) {
    			int bought = 0;
    			// 항목별
    			for(int i=0;i<items;i++) {
    				// 기준 할인율 이상이면 구매
    				if(d[i]>=user[0]) {
    					bought+=(int)(emoticons[i]*((double)(100-d[i])/100));
    					// 기준 가격 이상이면 가입
//    					System.out.println("user[1] = "+user[1]);
    					if(bought>=user[1]) {
    						localPlus++;
    						bought=0;
    						break;
    					}
    				}
    			}
    			localBought+=bought;
    		}
//    		System.out.println("localPlus = "+localPlus);
//    		System.out.println("LocalBought = "+localBought);
    		// 유저 순회하였음
    		// 최초 plus와 totalBought이 정해짐.
    		// 싼거부터 할인 줄이기.
    		// 기존보다 많아지면
    		if(plus<localPlus) {
    			plus=localPlus;
    			totalBought = localBought;
			// 가입자수는 같을때 
    		}else if(plus==localPlus) {
    			if(totalBought<localBought) {
    				totalBought=localBought;
    			}
    		}
			if(d[discP]==10) {
				// 값 원복
				d[discP]=40;
				discP++;
				if(discP>=items) {
					flag=false;
					break;
				}
				d[discP]-=10;
			}else {
				d[discP]-=10;
			}
    	}
    	
    	int[] result = {plus,totalBought};
    	System.out.println("RESULT = "+Arrays.toString(result));
        return result;
    }
	
	public static void main(String[] args) {
		int[][] users= {{40,10000},{25,10000}};
		int[] emoticons = {7000,9000};
		
		
		new Q3().solution(users, emoticons);
		
	}
}
