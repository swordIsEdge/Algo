package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 16:22
 **/

public class PascalSTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        if (numRows <= 0) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        if (numRows == 1) {
            return result;
        }

        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        result.add(list);
        if (numRows == 2) {
            return result;
        }

        List<Integer> last;
        for (int i = 3; i <= numRows; i++) {
            last = result.get(i - 2);
            list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i-1; j++) {
                list.add(last.get(j - 1) + last.get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
    public static void main(String... args){
        PascalSTriangle triangle = new PascalSTriangle();
        triangle.generate(5);

    }
}
