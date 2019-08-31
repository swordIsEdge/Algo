package org.zj.LeetCode.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-07-07 19:50
 **/

public class CourseSchedule {
    class GraphNode{
        int val;

        public GraphNode(int val) {
            this.val = val;
        }

        Set<GraphNode> pre = new HashSet<>();
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] pre = new boolean[numCourses];
        GraphNode[] nodes = new GraphNode[numCourses];

        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new GraphNode(i);
        }

        for (int[] prerequisite : prerequisites) {
            int start = prerequisite[1];
            int end = prerequisite[0];
            pre[start] = true;
            nodes[end].pre.add(nodes[start]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (pre[i]) {
                continue;
            }
            Stack<Integer> stack = new Stack<>();
            boolean[] used = new boolean[numCourses];

            stack.push(i);

            while (!stack.empty()) {
                int tmpNodeIndex = stack.pop();
                if (used[tmpNodeIndex]) {
                    return false;
                }
                used[tmpNodeIndex] = true;
            }

        }
        return true;









    }
















}
