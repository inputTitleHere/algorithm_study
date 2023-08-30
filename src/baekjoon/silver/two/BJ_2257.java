package baekjoon.silver.two;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_2257 {

    static Queue<Character> que;
    static Map<Character, Integer> table = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        que = input.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(LinkedList::new));
        table.put('H', 1);
        table.put('C', 12);
        table.put('O', 16);

        System.out.println(subMolecule());
    }

    static boolean checkIfNumber(char c) {
        int cn = c - '0';
        return 0 <= cn && cn <= 9;
    }

    static int subMolecule() {
        int localSum = 0;
        char next;
        while (!que.isEmpty() &&(next=que.poll())!=')') {
            if(next=='('){
                int local = subMolecule();
                if (!que.isEmpty() && checkIfNumber(que.peek())) {
                    localSum += local * (que.poll() - '0');
                }else{
                    localSum+=local;
                }
            }else{
                localSum += calc(next);
            }
        }
        return localSum;
    }

    static int calc(char next) {
        int mw = 0;
        switch (next) {
            case 'C':
            case 'O':
            case 'H':
                int mweight = table.get(next);
                if (!que.isEmpty() && checkIfNumber(que.peek())) {
                    mw += mweight * (que.poll() - '0');
                } else {
                    mw += mweight;
                }
                break;
        }
        return mw;
    }


}
