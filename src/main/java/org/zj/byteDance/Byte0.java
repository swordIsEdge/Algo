package org.zj.byteDance;

//import java.util.Scanner;
//
//public class Byte0 {
//    public static int getCount(int remain) {
//        int count = 0;
//        if (remain / 64 > 0) {
//            count += remain / 64;
//            remain = remain % 64;
//        }
//        if (remain / 16 > 0) {
//            count += remain / 16;
//            remain %= 16;
//        }
//
//        if (remain / 4 > 0) {
//            count += remain / 4;
//            remain %= 4;
//        }
//        count += remain;
//        return count;
//    }
//
//    //    private static int getCount(int remain) {
////        int count = 0;
////        count += remain / 64;
////        remain = remain%64;
////        count+=remain/16;
////        remain = remain%16;
////        count+=remain/4;
////        remain = remain%4;
////        count += remain;
////        return count;
////    }

import java.util.Scanner;

public class Byte0 {
    public static int getCount(int remain) {
        int count = 0;
        int count0 = remain / 64;
        if (count0 > 0) {
            count += count0;
            remain = remain % 64;
        }

        int count1 = remain / 16;
        if (count1 > 0) {
            count += count1;
            remain %= 16;
        }

        int count2 = remain / 4;
        if (count2 > 0) {
            count += count2;
            remain %= 4;
        }
        count += remain;
        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int num = Integer.valueOf(sc.nextLine());
            int remain = 1024 - num;
            if (remain <= 0) {
                System.out.println(0);
                continue;
            }
            System.out.println(getCount(remain));
        }
    }

}
