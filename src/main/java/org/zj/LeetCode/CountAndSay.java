package org.zj.LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kokoro at 2018/10/16
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("1");
        StringBuilder tmp = new StringBuilder();
        StringBuilder swapTp = null;

        for (int i = 1; i < n; i++) {
            swapTp = tmp;
            tmp = sb;
            sb = swapTp;

            sb.setLength(0);

            int len = tmp.length();
            int j = 0;
            int count = 0;
            while (j < len) {
                count = 1;
                while (j < len - 1 && tmp.charAt(j) == tmp.charAt(j + 1)) {
                    j++;
                    count++;
                }
                sb.append(count);
                sb.append(tmp.charAt(j));
                j++;
            }
        }

        return sb.toString();

    }

    @Test
    public void test() {
        int n = 4;
        String exp = "1211";
        String res = countAndSay(n);
        Assert.assertEquals(exp, res);


    }
}
