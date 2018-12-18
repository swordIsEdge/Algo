package org.zj;

class su extends pa {
    @Override
    public void test() {
        System.out.println("su");

    }
}

class pa {
    public void test() {
        System.out.println("pa");

    }
}

public class Test {
    public static void main(String... args) {
        pa p = new su();
        p.test();
    }
}
