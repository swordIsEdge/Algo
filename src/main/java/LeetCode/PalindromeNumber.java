package LeetCode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        int xDul = x;
        int y=0;
        while (x != 0) {
            y = y * 10 + (x % 10);
            x /= 10;
        }
        return y == xDul;


    }
}
