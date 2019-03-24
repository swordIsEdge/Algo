package org.zj.vchh;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-17 19:50
 **/

public class Main1 {
    static class Node{
        int index;
        int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Node> left = new PriorityQueue<>(Comparator.comparingInt(o -> o.index));
        PriorityQueue<Node> right = new PriorityQueue<>(Comparator.comparingInt(o -> o.index));
        int zeroData = 0;
        int n = Integer.parseInt(scanner.nextLine());
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            int index = Integer.parseInt(line[0]);
            int val = Integer.parseInt(line[1]);
            if (index == 0) {
                zeroData = val;
            } else if (index < 0) {
                left.add(new Node(-index, val));
                leftSum += val;
            } else {
                right.add(new Node(index, val));
                rightSum += val;
            }
        }
        int leftSize = left.size();
        int rightSize = right.size();
        int sum = 0;
        if (leftSize == rightSize) {
            sum = zeroData + leftSum + rightSum;
        } else if (leftSize < rightSize) {
            sum = zeroData + leftSum;
            for (int i = 0; i < leftSize + 1; i++) {
                sum += right.poll().val;
            }
        } else {
            sum = zeroData + rightSum;
            for (int i = 0; i < rightSize + 1; i++) {
                sum += left.poll().val;
            }
        }
        System.out.println(sum);

    }
}
