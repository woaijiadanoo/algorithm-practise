package com.jiangzh.algorithm.primary.c7;

import com.jiangzh.algorithm.primary.c6.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/path-sum-ii/
 * @author: Jiang Zheng
 * @date: 2025-10-22
 * @version: 1.0
 */
public class Code04_PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> path = new ArrayList<>();
        process(root, 0, targetSum, path, result);

        return result;
    }

    public void process(TreeNode root, int preSum, int targetSum, List<Integer> path, List<List<Integer>> result){
        if (root.left == null && root.right == null) {
            if (preSum + root.val == targetSum) {
                path.add(root.val);
                result.addLast(new ArrayList<>(path));
                path.removeLast();
            }
        }

        preSum = preSum + root.val;
        path.addLast(root.val);

        if (root.left != null) {
            process(root.left, preSum, targetSum, path, result);
        }

        if (root.right != null) {
            process(root.right, preSum, targetSum, path, result);
        }

        path.removeLast();
    }

}
