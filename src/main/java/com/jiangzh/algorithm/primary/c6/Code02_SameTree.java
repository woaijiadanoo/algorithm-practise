package com.jiangzh.algorithm.primary.c6;

/**
 * https://leetcode.cn/problems/same-tree
 */
public class Code02_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }

        if (p == null && q == null) {
            return true;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

    }

}
