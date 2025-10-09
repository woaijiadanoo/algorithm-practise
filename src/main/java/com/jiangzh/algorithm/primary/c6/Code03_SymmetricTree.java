package com.jiangzh.algorithm.primary.c6;

public class Code03_SymmetricTree {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null ^ root.right == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        return isSameTree(root.left, root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }

        if (p == null && q == null) {
            return true;
        }

        return p.val == q.val  && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }

}
