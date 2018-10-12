package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        core(new StringBuilder(n * 2), n, 0);
        return res;


    }

    private void core(StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }

        if (left > 0) {
            core(sb.append('('), left - 1, right+1);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right > 0) {
            core(sb.append(')'), left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    @Test
    public void test() {
        String[] expectArray = {"((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"};
        List<String> expect = Arrays.asList(expectArray);
        List<String> res = generateParenthesis(3);
        Assert.assertEquals(res, expect);

    }

}












