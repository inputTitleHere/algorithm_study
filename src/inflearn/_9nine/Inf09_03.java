package inflearn._9nine;

import java.util.*;
public class Inf09_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Entry> arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			arr.add(new Entry(sc.nextInt(),1));
			arr.add(new Entry(sc.nextInt(),0)); // a가 먼저.
		}
		Collections.sort(arr);
		int count = 0;
		int max = 0;
		for(Entry e : arr) {
			if(e.type==1){
				count++;
				max = Math.max(count, max);
			}else {
				count--;
			}
		}
		System.out.println(max);
	}
}

class Entry implements Comparable<Entry>{
	int time;
	int type;
	public Entry(int i, int o) {
		this.time=i; this.type=o;
	}
	public int compareTo(Entry e) {
		if(this.time==e.time) return this.type-e.type;
		else return this.time-e.time;
	}
}
