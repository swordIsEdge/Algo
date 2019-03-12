package org.zj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class su extends pa {
    @Override
    public void test() {
        System.out.println("su");

    }
}

class pa {
    public void test() {
        System.out.println("pa");

    }
}


public class Test {
    public static void main(String... args) {
        try {
            int x = 1 + 2;
        } catch (Exception e) {
            int y = 2;
            System.out.println(y);
        } finally {
            System.out.println(1);

        }
    }

    public String PrintMinNumber(int[] numbers) {
        int n;
        String s = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        n = numbers.length;
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);

        }
        Collections.sort(list, new Comparator<Integer>() {

            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        for (int j : list) {
            s += j;
        }
        return s;

    }
}
