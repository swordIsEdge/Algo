package org.zj.byteDance;
import java.text.DecimalFormat;
import java.util.*;

public class Byte1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        Arrays.sort(data);

        double max = data[n - 1];
        double min = (double)data[n-1]/m;

        while(max-min>0.001){
            double mid = (max+min)/2;
            if(core(mid, data, m)){
                min = mid;
            }else{
                max = mid;
            }
        }
        DecimalFormat fmt = new DecimalFormat("##0.00");
        System.out.println(fmt.format(max));
    }

    static boolean core(double mid, int[] data, int m){
        int count = 0;
        for(int i: data){
            count += (int)(i/mid);
            if(count >= m){
                return true;
            }
        }
        return false;

    }
}