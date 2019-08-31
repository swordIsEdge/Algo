package org.zj.LeetCode.medium;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-07 16:44
 **/

public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "0";
        }
        
        double dRes = 1.0d * numerator / denominator;
        String s = Double.toString(dRes);

        int index = s.indexOf('.');
        if (index < 0) {
            return s;
        }
        String left = s.substring(0, index);
        String right = s.substring(index + 1, s.length());
        for (int i = 1; i < s.length() / 2; i++) {

        }

        
        
        
        
        
        
        
        return s;
        
        
        
    }
}


















