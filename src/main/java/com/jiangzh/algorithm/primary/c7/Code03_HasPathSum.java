package com.jiangzh.algorithm.primary.c7;

import com.jiangzh.algorithm.primary.c6.TreeNode;

/**
 * https://leetcode.cn/problems/path-sum/
 * @author: Jiang Zheng
 * @date: 2025-10-19
 * @version: 1.0
 */
public class Code03_HasPathSum {

    private boolean hasPathSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        process(root, 0 , targetSum);
        return hasPathSum;
    }

    public void process(TreeNode root, int preSum, int targetSum) {
        if (root.left == null && root.right == null) {
            if(preSum + root.val == targetSum) {
                hasPathSum = true;
            }
            return;
        }

        preSum += root.val;

        if (root.left != null) {
            process(root.left, preSum, targetSum);
        }

        if (root.right != null) {
            process(root.right, preSum, targetSum);
        }
    }

}
