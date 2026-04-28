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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int mod = 0;

        // l1이 null이 아니거나, l2가 null이 아니거나, mod가 0이 아닌동안
        // 즉, 종료조건은 l1==null l2==null, mod==0 모든 조건이 부합할때 종료 
        while(l1 != null || l2 != null || mod != 0){
            int n1 = l1!=null?l1.val:0;
            int n2 = l2!=null?l2.val:0;
            int sum = n1 + n2 + mod;

            current.next = new ListNode(sum%10);
            mod = sum/10;

            l1 = l1!=null?l1.next:null;
            l2 = l2!=null?l2.next:null;
            current = current.next; 
        }
        return dummy.next;
    }
}