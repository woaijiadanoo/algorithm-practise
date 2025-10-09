package com.jiangzh.algorithm.primary.c6;

public class Code05_BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /*
        [3,9,20,15,7]
        [9,3,15,20,7]
     */
    public TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        if (preLeft == preRight) {
            return root;
        }

        int rootIndexInOrder = inLeft;
        while (inorder[rootIndexInOrder] != preorder[preLeft]) {
            rootIndexInOrder ++;
        }

        root.left = buildTree(preorder, inorder, preLeft + 1, preLeft + rootIndexInOrder - inLeft , inLeft, rootIndexInOrder - 1);
        root.right = buildTree(preorder, inorder, preLeft + rootIndexInOrder - inLeft + 1, preRight, rootIndexInOrder + 1, inRight);
        return root;
    }

    public static int arraySearch(int[] arrays, int target) {
        if (arrays == null || arrays.length == 0) {
            return -1;
        }

        int result =  0;
        while (arrays[result] != target) {
            result ++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Code05_BuildTree buildTree = new Code05_BuildTree();

        TreeNode treeNode = buildTree.buildTree(preorder, inorder);

        inOrder(treeNode);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

}
