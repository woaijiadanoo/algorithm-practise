package com.jiangzh.algorithm.primary.c7;

import com.jiangzh.algorithm.primary.c6.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Jiang Zheng
 * @date: 2025-10-11
 * @version: 1.0
 */
public class Code01_LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int queueSize = 0;
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            queueSize = queue.size();
            for (int i=0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.addFirst(levelList);
        }

        return result;
    }

}
