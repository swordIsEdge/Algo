package LeetCode;

//Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
public class Integer2Roman {
    public static void main(String... args) {
        String s = new Integer2Roman().intToRoman(3);
        System.out.println(s);
    }

    public String intToRoman(int num) {
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            while (num >= ints[i]) {
                sb.append(strings[i]);
                num -= ints[i];
            }
        }
        return sb.toString();
    }
}
