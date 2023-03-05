package baekjoon.gold.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_3954 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int tcase = 0; tcase < tc; tcase++) {
			stk = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(stk.nextToken()); // 배열 크기
			int c = Integer.parseInt(stk.nextToken()); // 코드 크기
			int in = Integer.parseInt(stk.nextToken()); // 입력 크기

			// 일반연산은 일반 방식으로 처리 -> 글자 입력은 char 넣기 -> +,-는 더한 다음 모듈러 연산.
			// 괄호의 경우 footprint를 기록 -> 동일하면 루프임?
			// 일단 그냥 시뮬 해보기(시간 될지는 모르겠음)

			char[] code = br.readLine().toCharArray(); // 코드
			char[] input = br.readLine().toCharArray();// 입력
			int[] cpmap = new int[c]; // code pointer map
			Stack<Integer> s = new Stack<Integer>();
			for (int i = 0; i < c; i++) {
				if (code[i] == '[') {
					s.add(i);
				} else if (code[i] == ']') {
					// l -> 좌 브라켓
					// i = 현재 = 우 브라켓
					int l = s.pop();
					cpmap[i] = l;
					cpmap[l] = i;
				}
			}

			int codeptr = 0;// 코드상 포인터
			int memptr = 0; // 메모리상 포인터
			int inputptr = 0;
			int[] mem = new int[m]; // 메모리
			int executeCount = 0; // 실행한 명령어 개수 -> 50,000,000넘는지 체크용
			boolean flag = false;
			while (executeCount <= 50_000_000) {
				if (codeptr == c) { // 정상적으로 끝나면.
					flag = true;
					break;
				}
				switch (code[codeptr]) {
				case '-': // 포인터가 가르키는 수 1 감소.
					mem[memptr] = (mem[memptr] + 255) % 256; // 자바에서 -1에 모듈러하면 음수나옴 -> 모듈러값-1을 더한 다음 모듈러 하면
																// 됨.(1-1)%256=(1+255)%256
					break;
				case '+': // 포인터가 가르키는 수 1 증가.
					mem[memptr] = (mem[memptr] + 1) % 256;
					break;
				case '<': // 포인터 왼쪽으로
					memptr = (memptr + m - 1) % m;
					break;
				case '>': // 포인터 오른쪽으로
					memptr = (memptr + 1) % m;
					break;
				case '[': // if 포인터 정보 == 0 짝 ]으로 점프(코드상)
					if (mem[memptr] == 0) { // 루프 나가가.
						codeptr = cpmap[codeptr];
					}
					// 데이터
					break;
				case ']': // if 포인터 정보 != 0 짝 [으로 점프
//					System.out.println("CP = "+codeptr);
//					System.out.println("mem[memptr]"+mem[memptr]);
					if (mem[memptr] != 0) { // 루프 탈출 못함 ->
						codeptr = cpmap[codeptr];
					}
					// 루프탈출
					break;
				case '.': // 포인터 수 출력(여기선 암것도 안함)
					break;
				case ',': // 문자 읽어서 포인터 정보에 저장. 입력배열 밖이면 255 입력
					if (inputptr == in) {
						mem[memptr] = 255;
					} else {
						mem[memptr] = input[inputptr++];
					}
					break;
				}
				codeptr++;
				executeCount++;
			}
			if (flag) {
				sb.append("Terminates").append("\n");
			} else {
				// 5천만 ~ 1억 사이의 최대 최소위치 구하기
				int mincptr=Integer.MAX_VALUE;
				int maxcptr=-1;
				while(executeCount<=100_000_000) {
					mincptr = Integer.min(codeptr, mincptr);
					maxcptr = Integer.max(maxcptr, codeptr);
					switch (code[codeptr]) {
					case '-': // 포인터가 가르키는 수 1 감소.
						mem[memptr] = (mem[memptr] + 255) % 256; // 자바에서 -1에 모듈러하면 음수나옴 -> 모듈러값-1을 더한 다음 모듈러 하면
																	// 됨.(1-1)%256=(1+255)%256
						break;
					case '+': // 포인터가 가르키는 수 1 증가.
						mem[memptr] = (mem[memptr] + 1) % 256;
						break;
					case '<': // 포인터 왼쪽으로
						memptr = (memptr + m - 1) % m;
						break;
					case '>': // 포인터 오른쪽으로
						memptr = (memptr + 1) % m;
						break;
					case '[': // if 포인터 정보 == 0 짝 ]으로 점프(코드상)
						if (mem[memptr] == 0) { // 루프 나가가.
							codeptr = cpmap[codeptr];
						}
						// 데이터
						break;
					case ']': // if 포인터 정보 != 0 짝 [으로 점프
//						System.out.println("CP = "+codeptr);
//						System.out.println("mem[memptr]"+mem[memptr]);
						if (mem[memptr] != 0) { // 루프 탈출 못함 ->
							codeptr = cpmap[codeptr];
						}
						// 루프탈출
						break;
					case '.': // 포인터 수 출력(여기선 암것도 안함)
						break;
					case ',': // 문자 읽어서 포인터 정보에 저장. 입력배열 밖이면 255 입력
						if (inputptr == in) {
							mem[memptr] = 255;
						} else {
							mem[memptr] = input[inputptr++];
						}
						break;
					}
					codeptr++;
					executeCount++;
				}
				sb.append("Loops ").append(mincptr-1).append(" ").append(maxcptr).append("\n");
			}
			// 여기까지 왔으면 사실상 일반종료.
			// Terminates는 위에서 처리함.
		}
		System.out.println(sb.toString());
	}
}
