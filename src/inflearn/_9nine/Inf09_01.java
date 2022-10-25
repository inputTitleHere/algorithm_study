package inflearn._9nine;

import java.util.*;
public class Inf09_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Applicant> a = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			a.add(new Applicant(sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(a);
		int maxW = a.get(0).w;
		int count = 1;
		for(int i=1;i<n;i++) {
			int curw = a.get(i).w;
			if(curw>maxW) {
				count++;
				maxW=curw;
			}
		}
		System.out.println(count);
	}
	
}
class Applicant implements Comparable<Applicant>{
	int h;
	int w;
	public Applicant(int h, int w) {
		this.h=h;
		this.w=w;
	}
	
	@Override
	public int compareTo(Applicant a) {
		return a.h-this.h;
	}
}
