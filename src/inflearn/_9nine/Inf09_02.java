package inflearn._9nine;

import java.util.*;
public class Inf09_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Meet> arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			arr.add(new Meet(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(arr);
		System.out.println(arr);
		int cnt=0;
		int endt = 0;
		for(Meet m : arr) {
			if(m.s>=endt) {
				cnt++;
				endt = m.e;
			}
		}
		System.out.println(cnt);
	}
}
class Meet implements Comparable<Meet>{
	int s;
	int e;
	public Meet(int s, int e) {
		this.s=s;
		this.e=e;
	}
	public int compareTo(Meet m) {
		if(this.e==m.e) return this.s-m.s;
		else return this.e-m.e; // 오름차순
		// 내림차순은 (비교값 - 기존값)
	}
	@Override
	public String toString() {
		return "["+s +" ~ "+e+"]";
	}
	
}
