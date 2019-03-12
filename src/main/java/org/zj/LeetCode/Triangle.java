package org.zj.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-28 09:40
 **/

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len== 0) {
            return 0;
        }
        if (len== 1) {
            return triangle.get(0).get(0);
        }

        ArrayList<Integer> ans = new ArrayList<>(triangle.get(len - 1));
        for (int i = len - 2; i >=0; i--) {
            List<Integer> tmp = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                ans.set(j, tmp.get(j) + Math.min(ans.get(j), ans.get(j + 1)));
            }
        }
        return ans.get(0);
    }
}
