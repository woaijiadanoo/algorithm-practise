package com.jiangzh.algorithm.primary.c6;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree
 */
public class Code04_MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
