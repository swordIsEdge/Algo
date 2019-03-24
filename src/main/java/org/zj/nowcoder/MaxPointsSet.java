package org.zj.nowcoder;

import java.util.*;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-13 08:18
 * https://www.nowcoder.com/practice/ea209d6014c44763a41ee04a11bf2ef1?tpId=90&tqId=30821&tPage=1&rp=1&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 **/

public class MaxPointsSet {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Node> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Node node = new Node(x, y);
            heap.offer(node);
        }
        Set<Node> set = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x - o2.x;
            }
        });
        int maxY = Integer.MIN_VALUE;
        while (!heap.isEmpty()) {
            Node node = heap.poll();
            if (node.y >= maxY) {
                maxY = node.y;
                set.add(node);
            }
        }
        for (Node node : set) {
            System.out.println(node.x + " " + node.y);
        }

    }

    private static class Node implements Comparable<Node>{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return  o.x-this.x;
        }
    }
}
