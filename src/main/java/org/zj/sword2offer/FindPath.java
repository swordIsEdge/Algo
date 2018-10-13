package org.zj.sword2offer;

import org.zj.dataStructure.ConstrucTreeNode;
import org.zj.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Author:kasumi
 * Date:2018/8/12
 */
public class FindPath {
    public static void main(String... args) {
        TreeNode root = ConstrucTreeNode.construc(new int[]{1,2,3,4,5,6,7,4,-1,-1,-1,2,1,-1,-1});
        FindPath fp = new FindPath();
        fp.FindPath(root, 11);
        System.out.println(fp.result);

    }
    ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        result = new ArrayList<>();
        FindPath(new ArrayList<Integer>(), root, target);
        result.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return result;
    }

    public void FindPath(ArrayList<Integer> path, TreeNode root, int remain) {
        if (root == null) {
            return;
        }


        path.add(root.val);
        if (root.val > remain) {
            return;
        }
        if (root.val == remain) {
            if (root.left == null && root.right == null) {
//                path.add(root.val);
                result.add(path);
                return;
            }
        }
        if (root.val < remain) {
            FindPath((ArrayList<Integer>) path.clone(), root.left, remain - root.val);
            FindPath((ArrayList<Integer>) path.clone(), root.right, remain - root.val);
        }
    }
}
