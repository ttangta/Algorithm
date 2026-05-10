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
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = dummy;

        while(head != null && head.next != null){
            ListNode n1 = head;
            ListNode n2 = head.next;
            ListNode tmp = head.next.next;
            n2.next = n1;
            n1.next = tmp;
            current.next = n2;
            head = n1.next;
            current = current.next.next;
        }
        return dummy.next;
    }
}