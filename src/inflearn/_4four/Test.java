package inflearn._4four;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Test {
	
	
	int no;
	String name;
	
	public Test(int no, String name) {
		this.no=no;
		this.name=name;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(name, no);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		return Objects.equals(name, other.name) && no == other.no;
	}
	
	public static void main(String[] args) {
		Map<Integer, Test> tmap = new HashMap<Integer, Test>();
		Test t1 = new Test(20, "홍길동");
		Test t2 = new Test(22, "신사임당");
		Test t3 = new Test(42, "임꺽정");
		int t1Hash = t1.hashCode();
		int t2Hash = t2.hashCode();
		int t3Hash = t3.hashCode();
		
		int size = 10;
		
		
		System.out.println(t1Hash);
		System.out.println(t1Hash ^ (t1Hash >>> 16));
		System.out.println(t1Hash&(size-1)); 
		System.out.println(t2Hash);
		System.out.println(t2Hash ^ (t2Hash >>> 16));
		System.out.println(t2Hash&(size-1));
		System.out.println(t3Hash);
		System.out.println(t3Hash ^ (t3Hash >>> 16));
		System.out.println(t3Hash&(size-1));
		
		System.out.println(8/3);
		System.out.println((float)8/3);
		
		
		
	}
	
	
	
}
