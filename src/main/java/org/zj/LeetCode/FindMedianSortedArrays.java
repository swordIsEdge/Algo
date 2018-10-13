package org.zj.LeetCode;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B, A);
        }

        int halfLen = (m + n + 1) / 2;
        int iMin = 0;
        int iMax = m;
        int i = iMin, j=0;
//        使用二分搜索法搜索i的值
        while (iMin <= iMax) {//此处必须为<=
            i = (iMax + iMin) / 2;
            j = halfLen - i;

            if (i < iMax && B[j-1] > A[i]){
                iMin = i+1;
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1;
            } else {
                if ((m + n) % 2 == 1) {
                    double res;
                    if (i == 0) {
                        res = B[j-1];
                    } else if (j == 0) {
                        res = A[i - 1];
                    } else {
                        res= Math.max(A[i - 1], B[j - 1]);
                    }
                    return res;

                } else {
                    double a,b;
                    if (i == 0) {
                        a = B[j-1];
                    } else if (j == 0) {
                        a = A[i - 1];
                    } else {
                        a= Math.max(A[i - 1], B[j - 1]);
                    }
                    if (i == m) {
                        b = B[j];

                    } else if (j == n) {
                        b = A[i];
                    } else {
                        b = Math.min(A[i], B[j]);
                    }
                    return (a + b) / 2.0;

                }

            }
        }
        return 0.0;





    }


    public static void main(String... args) {
//        FindMedianSortedArrays f = new FindMedianSortedArrays();
//        f.printArray(new int[]{1, 2, 3});
//        f.printPointer(2, "index");
//        double d = new FindMedianSortedArrays().findMedianSortedArrays(new int[]{0, 1, 2, 4, 5, 6}, new int[]{-3, -2, -1, 3, 9, 10});
        double d = new FindMedianSortedArrays().findMedianSortedArrays(new int[]{}, new int[]{2});
//        double d = new Solution().findMedianSortedArrays(new int[]{}, new int[]{1});
        System.out.println(d);
//        new FindMedianSortedArrays().findMedianSortedArrays2(new int[]{6,7,8,9}, new int[]{1,2,9,10,11});
//        new Solution().findMedianSortedArrays(new int[]{1, 2,3,4,5,6}, new int[]{3, 4,8,9,10});
    }

    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length) aMid = A[aStart + k / 2 - 1];
        if (bStart + k / 2 - 1 < B.length) bMid = B[bStart + k / 2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k / 2, B, bStart, k - k / 2);// Check: aRight + bLeft
        else
            return getkth(A, aStart, B, bStart + k / 2, k - k / 2);// Check: bRight + aLeft
    }

    public double findMedianSortedArrays2(int A[], int B[]) {
        int n = A.length;
        int m = B.length;
        // the following call is to make sure len(A) <= len(B).
        // yes, it calls itself, but at most once, shouldn't be
        // consider a recursive solution
        if (n > m)
            return findMedianSortedArrays2(B, A);

        // now, do binary search
        int halfLen = (n + m - 1) / 2;
        int iMin = 0, iMax = Math.min(halfLen, n); // r is n, NOT n-1, this is important!!
        int i=0, j=0;
        while (iMin < iMax) {
            i = (iMin + iMax) / 2;
            j = halfLen - i;
            printArray(A);
            printPointer(iMin,"iMin");

            printPointer(i , "i");
            printPointer(iMax,"iMax");

            printArray(B);
            printPointer(j , "j");
            System.out.println("********************************************");

            if (A[i] < B[j])
                iMin = i + 1;
            else
                iMax = i;


        }
        printArray(A);
        printPointer(iMin,"iMin");

        printPointer(i , "i");
        printPointer(iMax,"iMax");

        printArray(B);
        printPointer(j , "j");
        System.out.println("********************************************");

        // after binary search, we almost get the median because it must be between
        // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1]

        // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
        // and there are some corner cases we need to take care of.
        int a = Math.max(iMin > 0 ? A[iMin - 1] : Integer.MIN_VALUE, halfLen - iMin >= 0 ? B[halfLen - iMin] : Integer.MIN_VALUE);
        if (((n + m) & 1) == 1)
            return (double) a;

        // if (n+m) is even, the median can be calculated by
        //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
        // also, there are some corner cases to take care of.
        int b = Math.min(iMin < n ? A[iMin] : Integer.MAX_VALUE, halfLen - iMin + 1 < m ? B[halfLen - iMin + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }

    public void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%5d,", i);
        }
        System.out.println();
    }

    public void printPointer(int blankBeforePointer, String pointer) {
        for (int i = 0; i < blankBeforePointer; i++) {
            System.out.print("      ");

        }
        System.out.print("  ");
        System.out.print(pointer);
        System.out.println();
    }

    static class Solution {
        public double findMedianSortedArrays(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) { // to ensure m<=n
                int[] temp = A;
                A = B;
                B = temp;
                int tmp = m;
                m = n;
                n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && B[j - 1] > A[i]) {
                    iMin = i + 1; // i is too small
                } else if (i > iMin && A[i - 1] > B[j]) {
                    iMax = i - 1; // i is too big
                } else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) {
                        maxLeft = B[j - 1];
                    } else if (j == 0) {
                        maxLeft = A[i - 1];
                    } else {
                        maxLeft = Math.max(A[i - 1], B[j - 1]);
                    }
                    if ((m + n) % 2 == 1) {
                        return maxLeft;
                    }

                    int minRight = 0;
                    if (i == m) {
                        minRight = B[j];
                    } else if (j == n) {
                        minRight = A[i];
                    } else {
                        minRight = Math.min(B[j], A[i]);
                    }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }
    }

}
