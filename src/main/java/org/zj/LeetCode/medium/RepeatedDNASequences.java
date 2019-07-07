package org.zj.LeetCode.medium;

import javax.print.attribute.HashAttributeSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-06 11:17
 **/

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new LinkedList<>();
        }


        Set<Integer> set = new HashSet<>();
        int val = 0;
        for (int i = 0; i < 9; i++) {
            val <<= 2;
            val |= (mapChar(s.charAt(i)));
        }
        int mask = 0x000fffff;
        Set<String> result = new HashSet<>();
        for (int i = 9; i < s.length(); i++) {
            val <<= 2;
            val &= mask;
            val |= (mapChar(s.charAt(i)));
            if (!set.add(val)) {
                result.add(s.substring(i - 9, i + 1));

            }
        }
        return new LinkedList<>(result);
    }

    private int mapChar(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'T':
                return 1;
            case 'C':
                return 2;
            case 'G':

                return 3;
        }

        return 0;
    }

    public static void main(String... args){
        String s = "AAAAAGGGGGAAAAAGGGGGGAAAAACCCCTTT";
        RepeatedDNASequences obj = new RepeatedDNASequences();
        List<String> list = obj.findRepeatedDnaSequences(s);
        for (String s1 : list) {
            System.out.println(s1);
        }
    }
}
