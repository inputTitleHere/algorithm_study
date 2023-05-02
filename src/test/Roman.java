package test;

import java.util.*;

public class Roman {
	public static Scanner in = new Scanner(System.in);
	public static int n;
	public static String roman;
	public static int sum;
	public static String letters = "MDCLXVI";
	public static int value[] = { 1000, 500, 100, 50, 10, 5, 1 };
	public static int caseNum;

	public static void main(String[] args) {
		caseNum = 0;
		while ((n = in.nextInt()) != 0) {
			caseNum++;
			sum = 0;

			// Read input, convert each Roman number to decimal and add:
			for (int i = 0; i < n; i++) {
				roman = in.next();
				for (int j = 0; j < roman.length() - 1; j++) {
					char letter = roman.charAt(j); // look up current letter
					char nextLetter = roman.charAt(j + 1); // look up next letter
					int letterVal = value[letters.indexOf("" + letter)]; // get values
					int nextLetterVal = value[letters.indexOf("" + nextLetter)];

					// If current letter is less than next letter, subtract value
					// else add value:
					if (letterVal >= nextLetterVal)
						sum += letterVal;
					else
						sum -= letterVal;
				}

				// Process final letter:
				char letter = roman.charAt(roman.length() - 1);
				int letterVal = value[letters.indexOf("" + letter)];
				sum += letterVal;

//           System.out.println("DEBUG: sum so far = " + sum);
			}

			// Now convert sum back into Roman numerals.
			roman = "";
			String conversion[][] = { { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
					{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
					{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
					{ "", "M", "MM", "MMM", "MMMM", "MMMMM", "vM", "vMM", "vMMM", "Mx" },
					{ "", "x", "xx", "xxx", "xl", "l", "lx", "lxx", "lxxx", "xc" },
					{ "", "c", "cc", "ccc", "cd", "d", "dc", "dcc", "dccc", "cm" },
					{ "", "m", "mm", "mmm", "", "", "", "", "", "" } };

			int i = 0;
			while (sum > 0) {
				int digit = sum % 10;
				roman = conversion[i][digit] + roman;
				i++;
				sum = sum / 10;
			}

			String num = "";
			i = 0;
			sum = caseNum;
			while (sum > 0) {
				int digit = sum % 10;
				num = conversion[i][digit] + num;
				i++;
				sum = sum / 10;
			}

			System.out.println("Case " + num + ": " + roman);
		}
	}
}