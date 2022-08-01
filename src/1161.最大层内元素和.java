/*
 * @lc app=leetcode.cn id=1161 lang=java
 *
 * [1161] 最大层内元素和
 */

// @lc code=start

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        // 层次遍历队列
        Queue<TreeNode> queue = new ArrayDeque<>();
        // 记录每层的元素之和
        int maxLevel = 1;
        // 当前最大的和
        int currentMax = root.val;
        queue.offer(root);
        // 当前层的节点个数
        int levelNodeNum = 1;
        // 下一层的节点个数，用当前层非空节点数目乘2
        int nextLevelNodeNum = 0;
        // 本层已经遍历的节点数
        int currentNodeNum = 0;
        // 当前层的和
        int levelSum = 0;
        // 当前层
        int level = 1;
        while (!queue.isEmpty()) {
            currentNodeNum++;
            TreeNode node = queue.poll();
            levelSum += node.val;
            if (node.left != null) {
                nextLevelNodeNum++;
                queue.offer(node.left);
            }
            if (node.right != null) {
                nextLevelNodeNum++;
                queue.offer(node.right);
            }
            // 本层已经遍历到最后一个节点，结算本层节点
            if (currentNodeNum == levelNodeNum) {
                if (levelSum > currentMax) {
                    currentMax = levelSum;
                    maxLevel = level;
                }
                // 即将遍历下一层，重置currentNodeNum
                currentNodeNum = 0;
                levelNodeNum = nextLevelNodeNum;
                nextLevelNodeNum = 0;
                levelSum = 0;
                level++;
            }
        }
        return maxLevel;
    }


    // private List<Integer> sum = new ArrayList<Integer>();
    //
    // public int maxLevelSum(TreeNode root) {
    //     dfs(root, 0);
    //     int ans = 0;
    //     for (int i = 0; i < sum.size(); ++i) {
    //         if (sum.get(i) > sum.get(ans)) {
    //             ans = i;
    //         }
    //     }
    //     return ans + 1; // 层号从 1 开始
    // }
    //
    // private void dfs(TreeNode node, int level) {
    //     if (level == sum.size()) {
    //         sum.add(node.val);
    //     } else {
    //         sum.set(level, sum.get(level) + node.val);
    //     }
    //     if (node.left != null) {
    //         dfs(node.left, level + 1);
    //     }
    //     if (node.right != null) {
    //         dfs(node.right, level + 1);
    //     }
    // }

    public static void main(String[] args) {
        MaxLevelSum maxLevelSum = new MaxLevelSum();
        TreeNode node5 = new TreeNode(-8);
        TreeNode node4 = new TreeNode(7);
        TreeNode node3 = new TreeNode(0);
        TreeNode node2 = new TreeNode(7, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(node1);
        System.out.println(maxLevelSum.maxLevelSum(node1));
    }
}
// @lc code=end

