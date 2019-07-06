package org.zj.LeetCode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> -o[1]));
        int min = clips[0][0];
        if (min > 0) {
            return -1;
        }
        int max = clips[0][1];
        int count = 1;
        if (max >= T) {
            return count;
        }
        int nxt_max = max;

        for (int i = 1; i < clips.length; i++) {
            int[] clip = clips[i];
            if (clip[0] <= max && clip[1] >= nxt_max) {
                nxt_max = clip[1];
            }
            if (clip[0] > max) {
                if (clip[0] > nxt_max) {
                    return -1;
                }
                max = nxt_max;
                count++;
                if (nxt_max >= T) {
                    return count;
                }
            }
            if (nxt_max >= T) {
                return count + 1;
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] clips = {{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
        int T = 9;
        int res = new VideoStitching().videoStitching(clips, T);
        System.out.println(res);

    }
}

















