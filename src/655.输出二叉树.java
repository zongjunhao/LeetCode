/*
 * @lc app=leetcode.cn id=655 lang=java
 *
 * [655] 输出二叉树
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
class PrintTree {
    public List<List<String>> printTree(TreeNode root) {
        List<List<TreeNode>> nodes = new ArrayList<>();
        List<TreeNode> firstLayer = new ArrayList<>();
        firstLayer.add(root);
        nodes.add(firstLayer);
        boolean havaNode = true;
        while (havaNode) {
            havaNode = false;
            List<TreeNode> lastLayer = nodes.get(0);
            List<TreeNode> thisLayer = new ArrayList<>();
            for (TreeNode node : lastLayer) {
                if (node == null) {
                    thisLayer.add(null);
                    thisLayer.add(null);
                } else {
                    thisLayer.add(node.left);
                    thisLayer.add(node.right);
                    if (node.left != null || node.right != null) {
                        havaNode = true;
                    }
                }
            }
            if (havaNode) {
                nodes.add(0, thisLayer);
            }
        }
        System.out.println(nodes);

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            List<TreeNode> thisLayer = nodes.get(i);
            List<String> resultLayer = new ArrayList<>();
            for (int j = 0; j < (1 << i) - 1; j++) {
                resultLayer.add("");
            }
            for (int j = 0; j < thisLayer.size(); j++) {
                if (thisLayer.get(j) == null) {
                    resultLayer.add("");
                } else {
                    resultLayer.add(String.valueOf(thisLayer.get(j).val));
                }
                if (j != thisLayer.size() - 1) {
                    for (int k = 0; k < (1 << (i + 1)) - 1; k++) {
                        resultLayer.add("");
                    }
                }
            }
            for (int j = 0; j < (1 << i) - 1; j++) {
                resultLayer.add("");
            }
            ans.add(0, resultLayer);
        }
        System.out.println(ans);
        return null;
    }

    public static void main(String[] args) {
        PrintTree printTree = new PrintTree();
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, null, node4);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(printTree.printTree(node1));

        // PrintTree printTree = new PrintTree();
        // TreeNode node2 = new TreeNode(2);
        // TreeNode node1 = new TreeNode(1, node2, null);
        // System.out.println(printTree.printTree(node1));
    }

}
// @lc code=end

