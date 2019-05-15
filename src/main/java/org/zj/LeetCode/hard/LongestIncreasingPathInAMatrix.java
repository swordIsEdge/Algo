package org.zj.LeetCode.hard;

import java.util.PriorityQueue;

public class LongestIncreasingPathInAMatrix {
    int max = Integer.MIN_VALUE;
    int[][] matrix;

    int longestPath(int[][] matrix, int m, int n) {
        this.matrix = matrix;
        int[][] length = new int[m][n];
        PriorityQueue<Point> heap = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heap.add(new Point(i, j, matrix[i][j]));
            }
        }
        for (Point point : heap) {
            fillPoint(length, point);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Integer.max(max, length[i][j]);
            }
        }
        return max;

    }

    void fillPoint(int[][] pathLen, Point p) {
        // x-1,y
        // x+1,y
        // x,y-1
        // x,y+1
        int[][] matrix = this.matrix;
        int tmpMax = 0;
        if (p.x - 1 >= 0 && matrix[p.x - 1][p.y] < p.val) {

            tmpMax = Integer.max(tmpMax, pathLen[p.x - 1][p.y]);
        }
        if (p.x + 1 < pathLen.length && matrix[p.x + 1][p.y] < p.val) {
            tmpMax = Integer.max(tmpMax, pathLen[p.x + 1][p.y]);
        }
        if (p.y - 1 >= 0 && matrix[p.x][p.y - 1] < p.val) {
            tmpMax = Integer.max(tmpMax, pathLen[p.x][p.y - 1]);
        }
        if (p.y + 1 < pathLen[0].length && matrix[p.x][p.y + 1] < p.val) {
            tmpMax = Integer.max(tmpMax, pathLen[p.x][p.y + 1]);
        }

        pathLen[p.x][p.y] = tmpMax + 1;
        if (p.x - 1 >= 0 && matrix[p.x - 1][p.y] > p.val) {
            pathLen[p.x - 1][p.y] = tmpMax + 2;
        }
        if (p.x + 1 < pathLen.length && matrix[p.x + 1][p.y] > p.val) {
            pathLen[p.x + 1][p.y] = tmpMax + 2;

        }
        if (p.y - 1 >= 0 && matrix[p.x][p.y - 1] > p.val) {
            pathLen[p.x][p.y - 1] = tmpMax + 2;

        }
        if (p.y + 1 < pathLen[0].length && matrix[p.x][p.y + 1] > p.val) {
            pathLen[p.x][p.y - 2] = tmpMax + 2;

        }

    }

    static class Point implements Comparable<Point> {
        int x, y;
        int val;

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Point o) {
            return this.val - o.val;
        }
    }
}
