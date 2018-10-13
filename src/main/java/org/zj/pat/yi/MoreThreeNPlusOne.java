package org.zj.pat.yi;

import java.util.*;
public class MoreThreeNPlusOne {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Set<Integer> hasSet = new TreeSet<>();
        BitSet bitSet = new BitSet();

        for (int i = 0; i < k; i++) {
            int n = scanner.nextInt();
            hasSet.add(n);
        }
        for (Integer integer : hasSet) {
            while (integer != 1) {
                if (integer % 2 == 0) {
                    integer /= 2;
                } else {
                    integer = (integer + (integer << 1) + 1) / 2;
                }

                if (hasSet.contains(integer)) {
                    bitSet.set(integer);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : ((TreeSet<Integer>) hasSet).descendingSet()) {
            if (!bitSet.get(integer)) {
                sb.append(integer);
                sb.append(" ");
            }
        }
        System.out.print(sb.subSequence(0,sb.length()-1));


    }
}
