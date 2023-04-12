package baekjoon.bronze.four;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
/**
 * 이거 COBOL 언어 제한있어서 그냥 자바로만 코드 쓰고 COBOL 코드 복붙했음.
 * COBOL출력시 앞에 7개의 공백을 띄어야 컴파일 에러 안뜸.
 * @author SSAFY
 *
 */
public class BJ_2393 {
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("  ___  ___  ___\n");
		bw.write("  | |__| |__| |\n");
		bw.write("  |           |\n");
		bw.write("   \\_________/\n");
		bw.write("    \\_______/\n");
		bw.write("     |     |\n");
		bw.write("     |     |\n");
		bw.write("     |     |\n");
		bw.write("     |     |\n");
		bw.write("     |_____|\n");
		bw.write("  __/       \\__\n");
		bw.write(" /             \\\n");
		bw.write("/_______________\\");
		bw.flush();
	}
}
