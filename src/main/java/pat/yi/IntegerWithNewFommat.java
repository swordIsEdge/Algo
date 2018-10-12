package pat.yi;

import java.util.Scanner;

public class IntegerWithNewFommat {
    public static void main(String... args){
        int[] ints = {100, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        String[] ss = {"B","S","123456789","12345678","1234567","123456","12345","1234","123","12","1"};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            while (n >= ints[i]) {
                sb.append(ss[i]);
                n -= ints[i];
            }
        }
        System.out.println(sb);
    }
}
