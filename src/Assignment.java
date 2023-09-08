import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Assignment {
	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
		int year = date.getYear();
		int month = date.getMonthValue()-1;
		System.out.println("year = " + year + " month = " + month);
		List<Integer> days = new ArrayList<>();
		days.add(31); // 1
		days.add(28); // 2
		days.add(31); // 3
		days.add(30); // 4
		days.add(31); // 5
		days.add(30); // 6
		days.add(31); // 7
		days.add(31); // 8
		days.add(30); // 9
		days.add(31); // 10
		days.add(30); // 11
		days.add(31); // 12
		int day = days.get(month);
		if(month==1 && ((year%4==0)&&(year%100!=0)||(year%400)==0)) {
			day++;
		}
		System.out.printf("%d days for %d/%d\n",day,year,month+1);
	}
}
