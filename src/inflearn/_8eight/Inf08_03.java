package inflearn._8eight;

import java.util.*;
public class Inf08_03 {
	
	static int score=0;
	static int max = 0;
	static int time=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Question[] in = new Question[n];
		for(int i=0;i<n;i++) in[i]=new Question(sc.nextInt(), sc.nextInt());
		calc(in,0,n,m);
		System.out.println(max);
	}
	static void calc(Question[] in, int curr, int n,int m) {
		if(time>m) return;
		if(score>max) max=score;
		if(curr==n) return;
		
		score+=in[curr].getPoint();
		time+=in[curr].getTime();
		calc(in,curr+1,n,m);
		score-=in[curr].getPoint();
		time-=in[curr].getTime();
		calc(in,curr+1,n,m);
	}
}
class Question{
	int point;
	int time;
	public Question(int point, int time) {
		this.point = point;
		this.time = time;
	}
	public int getPoint() {
		return point;
	}
	public int getTime() {
		return time;
	}
}

