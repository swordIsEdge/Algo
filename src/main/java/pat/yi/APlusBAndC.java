package pat.yi;

import java.util.Scanner;

public class APlusBAndC {
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long a, b, c;
        for (int i = 0; i < T; i++) {
            a = sc.nextLong();
            b = sc.nextLong();
            c = sc.nextLong();
            System.out.println("Case #"+(i+1)+": "+(a+b>c));

        }
    }
}
