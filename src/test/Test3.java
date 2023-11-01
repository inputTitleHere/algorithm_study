package test;

import java.util.*;
public class Test3 {
    public static void main(String[] args) {

        Set<Integer> keySet = new TreeSet<>();
        keySet.add(3);
        keySet.add(5);
        keySet.add(1);
        keySet.add(12);
        keySet.add(9);
        ArrayList<Integer> arr = new ArrayList<>(keySet);
        System.out.println(arr);

    }
}
