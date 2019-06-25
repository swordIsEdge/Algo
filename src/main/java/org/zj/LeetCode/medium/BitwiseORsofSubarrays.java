package org.zj.LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsofSubarrays {

    public int subarrayBitwiseORs(int[] A) {
        if (A == null|| A.length ==0){
            return 0;
        }
        if (A.length==1){
            return 1;
        }

        Set<Integer> result = new HashSet<>();
        Set<Integer>tmp,last = new HashSet<>();
        for (int integer : A) {
            tmp = new HashSet<>();
            tmp.add(integer);
            for (Integer integer1 : last) {
                tmp.add(integer|integer1);
            }
            result.addAll(tmp);
            last = tmp;

        }
        return result.size();
    }

    public static void main(String[] args) {
        int[] A = {1,2,2};
        int res = new BitwiseORsofSubarrays().subarrayBitwiseORs(A);
        System.out.println(res);
    }
}
