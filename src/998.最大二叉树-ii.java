/*
 * @lc app=leetcode.cn id=998 lang=java
 *
 * [998] 最大二叉树 II
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
class InsertIntoMaxTree {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode lastPointer = root;
        TreeNode pointer;
        if (root.val < val) {
            return new TreeNode(val, root, null);
        } else {
            pointer = root.right;
        }

        while (pointer != null && val < pointer.val) {
            lastPointer = pointer;
            pointer = pointer.right;
        }

        TreeNode newNode = new TreeNode(val);
        lastPointer.right = newNode;
        if (pointer != null) {
            newNode.left = pointer;
        }
        return root;
    }

    public static void main(String[] args) {
        InsertIntoMaxTree insertIntoMaxTree = new InsertIntoMaxTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, null, node1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5, node2, node4);
        System.out.println(node5);
        System.out.println(insertIntoMaxTree.insertIntoMaxTree(node5, 4));
    }
}
// @lc code=end

