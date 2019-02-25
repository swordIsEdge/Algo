package org.zj.LeetCode;

import org.zj.dataStructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-19 13:08
 **/

public class RestoreIPAddresses {
    List<List<Integer>> result;
    int[] digits;

    public List<String> restoreIpAddresses(String s) {
        this.result = new ArrayList<>();
        if (s.length() < 4) {
            return new ArrayList<>();
        }

        digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        ArrayList<Integer> ip = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            ip.add(-1);
        }
        core(ip, 0, 0);
        List<String> res = new ArrayList<>();
        for (List<Integer> integers : result) {
            StringBuilder sb = new StringBuilder();
            sb.append(integers.get(0));
            sb.append('.');
            sb.append(integers.get(1));
            sb.append('.');
            sb.append(integers.get(2));
            sb.append('.');
            sb.append(integers.get(3));
            res.add(sb.toString());
        }

        return res;
    }

    private void core(ArrayList<Integer> ip, int index, int start) {
        if (index == 4) {
            if (start == digits.length) {
                //加入结果
                result.add((List<Integer>) ip.clone());
                return;
            } else {
                //还有剩余的数
                return;
            }
        }
        if (start == digits.length) {
            return;
        }

//        for (int i = start; i < digits.length; i++) {

        int tmp = 0;
        for (int j = start; j < start + 3 && j < digits.length; j++) {
            tmp = tmp * 10 + digits[j];
            if (tmp > 255) {
                break;
            }
            ip.set(index, tmp);
            core(ip, index + 1, j + 1);
            if (tmp == 0) {
                break;
            }
        }
    }

    public static void main(String... args) {
        String s = "010010";
        List<String> res = new RestoreIPAddresses().restoreIpAddresses(s);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
