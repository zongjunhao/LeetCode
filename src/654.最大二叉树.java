/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 */

// @lc code=start

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
class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxPos = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxPos]) {
                maxPos = i;
            }
        }
        return new TreeNode(nums[maxPos], construct(nums, start, maxPos - 1), construct(nums, maxPos + 1, end));
    }

    public static void main(String[] args) {
        ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();
        System.out.println(constructMaximumBinaryTree.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }
}
// @lc code=end

