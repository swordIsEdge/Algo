package org.zj.pat.yi;

import java.util.BitSet;
import java.util.Scanner;

public class IWantAc {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
//        sc.nextLine();
        BitSet set = new BitSet();
        set.set('P');
        set.set('A');
        set.set('T');

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            if (s.length() == 0) {
                System.out.println("NO");
                continue;
            }
            char[] chars = s.toCharArray();
            int startA = 0, p = 0, midA = 0, t = 0, endA = 0;
            boolean ac = true;
            nxt:
            for (char c : chars) {
                if (!set.get(c)) {
                    System.out.println("NO");
                    ac = false;
                    break;
                }
                switch (c) {
                    case 'A':
                        if (p == 0) {
                            startA++;
                        } else if (p > 0 && t == 0) {
                            midA++;
                        } else {
                            endA++;
                        }
                        break;
                    case 'P':
                        if (t > 0) {
                            System.out.println("NO");
                            ac = false;
                            break nxt;
                        }
                        p++;
                        break;
                    case 'T':
                        t++;
                        break;

                }
                if (p > 1 || t > 1) {
                    System.out.println("NO");
                    ac = false;
                    break;
                }
            }
            if (ac) {
                if (p==1&&t==1&&midA>0 && endA == midA * startA) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }
}

