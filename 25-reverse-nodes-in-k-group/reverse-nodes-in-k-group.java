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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while(true){
            ListNode check = prevGroupEnd;
            for(int i=0; i<k; i++){
                check = check.next;
                if(check == null)return dummy.next;
            }
            ListNode prev = null;
            ListNode cur = prevGroupEnd.next;
            ListNode groupStart = cur;
            for(int i=0; i<k; i++){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            prevGroupEnd.next = prev;
            groupStart.next = cur;
            prevGroupEnd = groupStart;
        }
    }
}