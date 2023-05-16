package baekjoon.bronze.four;

import java.io.*;

public class BJ_6825 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double weight = Double.parseDouble(br.readLine());
		double height = Double.parseDouble(br.readLine());
		double bmi = weight/(height*height);
		if(bmi<18.5) {
			System.out.println("Underweight");
		}else if(18.5<=bmi && bmi<=25.0) {
			System.out.println("Normal weight");
		}else {
			System.out.println("Overweight");
		}
	}
}
