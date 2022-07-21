/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode firstNode = head;

        ListNode rawLastNode = head;
        while (rawLastNode.next!=null){
            rawLastNode = rawLastNode.next;
        }
        while (firstNode!=rawLastNode){
            ListNode tempNode = firstNode;
            firstNode = firstNode.next;
            tempNode.next = rawLastNode.next;
            rawLastNode.next = tempNode;
        }
        return rawLastNode;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        int[] nodes = new int[]{1,2,3,4,5};
        ListNode head = new ListNode(nodes[0]);
        ListNode lastNode = head;
        for (int i = 1; i < nodes.length; i++) {
            ListNode node = new ListNode(nodes[i]);
            lastNode.next = node;
            lastNode = node;
        }
        for(ListNode node = head; node!=null; node = node.next){
            System.out.println(node);
        }
        System.out.println();
        ListNode reverseNode = reverseList.reverseList(head);
        for(ListNode node = reverseNode; node!=null; node = node.next){
            System.out.println(node);
        }
    }
}
// @lc code=end

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
