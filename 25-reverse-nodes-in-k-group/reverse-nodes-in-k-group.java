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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1)return head;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prevGroup = dummy;

        while(true){
            ListNode kth = prevGroup;
            for(int i=0; i<k; i++){
                kth = kth.next;
                if(kth == null)return dummy.next;
            }

            ListNode prev = null;
            ListNode current = prevGroup.next;
            ListNode startGroup = current;
            for(int i=0; i<k; i++){
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            ListNode nextNode = kth.next;
            prevGroup.next = prev;
            startGroup.next = current;
            prevGroup = startGroup;
        }
    }
}