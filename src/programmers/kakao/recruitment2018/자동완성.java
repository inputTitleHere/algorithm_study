package programmers.kakao.recruitment2018;

import java.util.*;

public class 자동완성 {
    public int solution(String[] words) {
        Node init = new Node();

        for (String s : words) {
            Node node = init;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (node.map.containsKey(c)) {
                    node = node.map.get(c);
                } else {
                    Node newNode = new Node();
                    node.map.put(c, newNode);
                    node = newNode;
                }
                node.count++;
            }

        }
        int answer = 0;
        SEARCH:
        for (String s : words) {
            Node node = init;
            char[] chars = s.toCharArray();
            int step = 1;
            for (char c : chars) {
                node = node.map.get(c);
                if (node.count == 1) {
                    answer += step;
                    continue SEARCH;
                }
                step++;
            }
            answer += step - 1;
        }
        return answer;
    }

    static class Node {
        public Map<Character, Node> map;
        public int count;

        public Node() {
            count = 0;
            map = new HashMap<>();
        }
    }
}