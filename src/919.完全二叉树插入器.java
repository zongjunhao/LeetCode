/*
 * @lc app=leetcode.cn id=919 lang=java
 *
 * [919] 完全二叉树插入器
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    // 层次遍历，保存当前左右孩子存在空缺的节点
    Queue<TreeNode> candidate;
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.candidate = new ArrayDeque<>();
        this.root = root;

        Queue<TreeNode> tempQueue = new ArrayDeque<>();
        if (root!=null){
            tempQueue.offer(root);
        }
        while (!tempQueue.isEmpty()){
            TreeNode node = tempQueue.poll();
            if (node.left!=null){
                tempQueue.offer(node.left);
            }
            if (node.right!=null){
                tempQueue.offer(node.right);
            }
            if (node.left==null||node.right==null){
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        TreeNode candidateNode = candidate.peek();
        if (candidateNode.left == null){
            candidateNode.left = newNode;
        }else {
            candidateNode.right = newNode;
            candidate.poll();
        }
        candidate.offer(newNode);
        return candidateNode.val;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        CBTInserter cbtInserter = new CBTInserter(root);
        System.out.println(cbtInserter.insert(2));
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
// @lc code=end

