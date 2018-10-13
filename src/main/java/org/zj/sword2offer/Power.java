package org.zj.sword2offer;

/**
 * Author:kasumi
 * Date:2018/8/7
 */
public class Power {
    public static void main(String... args){
        Power power = new Power();
        double base = 5.0d;
        int exponent = -2;
        System.out.println(power.Power(base, exponent));

    }
    public double Power(double base, int exponent) {
        int sign, expAbs;
        boolean overFlow = false;

        if (exponent == Integer.MIN_VALUE) {
            overFlow = true;
            sign = -1;
            expAbs = Integer.MAX_VALUE;
        }

        if (exponent >= 0) {
            sign = 1;
            expAbs = exponent;
        } else {
            sign = -1;
            expAbs = -exponent;
        }

        double power = 1d;
        double powerTmp = 1d;
        while (expAbs > 0) {
            powerTmp *= base;
            if ((expAbs & 0x00000001) > 0) {
                power *= powerTmp;
            }
            expAbs = expAbs >> 1;
        }
        if (overFlow) {
            power *= base;
        }
        if (sign < 0) {
            power = 1 / power;
        }

        return power;
    }
}
