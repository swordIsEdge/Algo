package org.zj.test;

import org.omg.CORBA.Environment;

import java.util.Scanner;

public class LongTimeRunner {
    public static void main(String... args)throws InterruptedException{
        String str = System.getProperty("java.io.tmpdir");
        System.out.println(str);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNext()) {
                    String s = scanner.nextLine();
                    System.out.println(s);

                }
            }
        });
        t.start();
        t.join();

    }
}
