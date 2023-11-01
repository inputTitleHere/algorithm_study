package programmers.level.two;

import java.util.*;

public class 시소짝꿍 {

    public long solution(int[] weights) {
        // 2,3,4
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];
            Integer occurence = map.get(weight);
            if (occurence != null) {
                map.put(weight, occurence + 1);
            } else {
                map.put(weight, 1);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>(map.keySet());

        int[][] weightCache = new int[1001][];
        for (int i : arr) {
            weightCache[i] = new int[]{i * 2, i * 3, i * 4};
        }

        int size = arr.size();
        long count = 0;
        for (int i = 0; i < size; i++) {
            int iWeight = arr.get(i);
            count += combinateSelf((long) map.get(iWeight));
            for (int j = i + 1; j < size; j++) {
                int jWeight = arr.get(j);
                if (checkMatch(weightCache[iWeight], weightCache[jWeight])) {
                    count += (long) map.get(iWeight) * map.get(jWeight);
                }
            }
        }
        return count;
    }

    public long combinateSelf(long count) {
        return (count * (count - 1L)) / 2L;
    }

    public boolean checkMatch(int[] lighter, int[] heavier) {
        // 가벼운거 2,3,4 | 무거운거 2,3,4
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < i; j++) {
                if (lighter[i] == heavier[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}