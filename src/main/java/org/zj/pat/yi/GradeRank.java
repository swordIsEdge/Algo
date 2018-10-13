package org.zj.pat.yi;

import java.util.Scanner;

public class GradeRank {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        if (n <= 0) {
            return;
        }
        int high = Integer.MIN_VALUE;
        String highName="";
        String highCode="";

        int low = Integer.MAX_VALUE;
        String lowName="";
        String lowCode="";

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();


            String[] inputs = input.split(" ");
            int mark = Integer.parseInt(inputs[inputs.length - 1]);
            if (mark > high) {
                highName = inputs[0];
                highCode = inputs[1];
                high = mark;
            }
            if (mark < low) {
                lowName = inputs[0];
                lowCode = inputs[1];
                low = mark;
            }

        }
        System.out.println(highName + " " + highCode);
        System.out.println(lowName+" "+lowCode);

    }
}
