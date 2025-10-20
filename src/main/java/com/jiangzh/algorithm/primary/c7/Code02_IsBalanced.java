package com.jiangzh.algorithm.primary.c7;

import com.jiangzh.algorithm.primary.c6.TreeNode;

/**
 * @author: Jiang Zheng
 * @date: 2025-10-14
 * @version: 1.0
 */
public class Code02_IsBalanced {

    class Info {
        public int height;
        public boolean isBalanced;

        public Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    /**
        判断一棵树是否是平衡二叉树
        判断依据是左树和右树的高度差不能大于 1
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return process(root).isBalanced;
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, true);
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;

        return new Info(height, isBalanced);
    }

}
