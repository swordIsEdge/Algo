package org.zj.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class CourseSchedule {
    public static void main(String... args) {
        int n = 4;
//        int[][] req = {{1, 0},{0,1}};
        int[][] req = {{0, 1}, {0, 2}, {1, 3}, {3, 0}};
        boolean res = new CourseSchedule().canFinish(n, req);
        System.out.println(res);

    }

    class GraphNode {
        int val;
        Set<GraphNode> nextNodes;

        GraphNode(int val) {
            this.val = val;
            this.nextNodes = new HashSet<>();
        }

        public void addNextNode(GraphNode graphNode) {
            nextNodes.add(graphNode);

        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        GraphNode[] nodesArray = new GraphNode[numCourses];
        boolean[] noCircle = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodesArray[i] = new GraphNode(i);
        }
        int requests = prerequisites.length;
        for (int i = 0; i < requests; i++) {
            GraphNode second = nodesArray[prerequisites[i][1]];
            GraphNode first = nodesArray[prerequisites[i][0]];
            first.addNextNode(second);
        }
        boolean[] used = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!noCircle[i]) {
                if (!dfs(nodesArray[i], used, noCircle)) {
                    return false;
                } else {
                    noCircle[i] = true;
                }
            }
        }
        return true;


    }

    private boolean dfs(GraphNode root, boolean[] used, boolean[] noCircle) {
        if (noCircle[root.val]) {
            return true;
        }
        if (used[root.val]) {
            return false;
        }
        used[root.val] = true;
        for (GraphNode nextNode : root.nextNodes) {
            if (!dfs(nextNode, used, noCircle)) {
                return false;
            } else {
                noCircle[root.val] = true;
            }
        }
        used[root.val] = false;
        noCircle[root.val] = true;
        return true;
    }
}
