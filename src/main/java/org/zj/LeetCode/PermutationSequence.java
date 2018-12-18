package org.zj.LeetCode;

import java.util.ArrayList;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-17 14:46
 **/

public class PermutationSequence {
    ArrayList<Integer> arrayList;
    char[] result;

    int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }
        result = new char[n];
        this.arrayList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arrayList.add(i);
        }
        int fac = factorial(n - 1);
        core(0, k,fac,n-1);
        return new String(result);
    }

    private void core(int index, int k,int fac,int n) {
        if (index == result.length - 1) {
            result[index] = (char) (arrayList.get(arrayList.size()-1)+'0');
            return;
        }

        int o = (int) Math.ceil(k * 1.0 / fac);
        o = o == 0 ? arrayList.size() - 1 : o;
        result[index] = (char) (arrayList.get(o)+'0');
        arrayList.remove(o);
        core(index+1,k%fac,fac/n,n-1);
    }
    public static void main(String... args){
        int n = 3;
        int k = 3;
        String s = new PermutationSequence().getPermutation(n, k);
        System.out.println(s);

    }
}
