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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)return null;
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(list1 != null && list2 != null){
            current.next = new ListNode();
            current = current.next;

            int n1 = list1.val;
            int n2 = list2.val;

            if(n1 <= n2){
                current.val = n1;
                if(list1 != null)list1 = list1.next;
            }
            else{
                current.val = n2;
                if(list2 != null)list2 = list2.next;
            }
        }
        while(list1 != null){
            current.next = new ListNode();
            current = current.next;
            current.val = list1.val;
            if(list1 != null)list1 = list1.next;
        }
        while(list2 != null){
            current.next = new ListNode();
            current = current.next;
            current.val = list2.val;
            if(list2 != null)list2 = list2.next;
        }
        return dummy.next;
    }
}