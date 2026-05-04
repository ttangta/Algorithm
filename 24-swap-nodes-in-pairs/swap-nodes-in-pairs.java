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
        ListNode current = dummy;

        while(head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;

            first.next = second.next;
            second.next = first;

            current.next = second;
            head = first.next;
            current = first;
        }

        if(head!=null){
            current.next = head;
        }
        return dummy.next;
    }
}