package org.zj.LeetCode.easy;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if (!isBadVersion(n)) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int lo = 1, hi = n;
        int mid = lo + (hi - lo) >> 1;
        while (lo < hi) {

            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
            mid = lo + ((hi - lo) >> 1);

        }
        return mid;

    }

    boolean isBadVersion(int version) {
        if (version >= 4) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        new FirstBadVersion().firstBadVersion(n);

    }
}
