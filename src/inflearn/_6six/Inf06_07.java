package inflearn._6six;

import java.util.*;
import java.io.*;
public class Inf06_07 {
	public static void main(String[] args) throws IOException{
		// tc 100,000 많다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] p = new Point[n];
		for(int i=0;i<n;i++) {
			String[] in = br.readLine().split("\\s");
			p[i] = new Point(Integer.parseInt(in[0]),Integer.parseInt(in[1]));
		}
		Arrays.sort(p, (Comparator<? super Point>)(Point pa, Point pb)->{ // return이 음수면 비교값을 왼쪽에 둠. -> 양수면 비교값을 오른쪽에 둠.
			if(pa.getX()<pb.getX()) return -1;
			else if(pa.getX()==pb.getX()) {
				if(pa.getY()<pb.getY()) {
					return -1;
				}
			}
			return 1; // 0이면 do nothing임
		});
		for(int i=0;i<n;i++) {
			System.out.println(p[i]);
		}
	}
	
}

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public String toString() {
		return x + " " + y;
	}
}

