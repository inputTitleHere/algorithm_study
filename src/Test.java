
public class Test {
	public static void main(String[] args) {
		System.out.println(bitcount(8));
	}
	
	static int bitcount(int num) {
		int count =0;
		while(num>0) {
			count+=num%2;
			num>>=1;
		}
		return count;
	}
}
