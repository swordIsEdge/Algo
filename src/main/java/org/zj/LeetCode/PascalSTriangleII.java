package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 16:57
 **/

public class PascalSTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);

        result.add(1);
        if (rowIndex == 0) {
            return result;
        }

        result.add(1);
        if (rowIndex == 1) {
            return result;
        }

        for (int i = 2; i <=rowIndex ; i++) {
            result.add(1);
            for (int j = i-1; j >=1 ; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
    public static void main(String... args){
        PascalSTriangleII pascalSTriangleII = new PascalSTriangleII();
        List<Integer> res = pascalSTriangleII.getRow(3);
        System.out.println(res);

    }
}
