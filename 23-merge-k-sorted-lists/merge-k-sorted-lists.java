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
 import java.util.*;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));

        for(int i=0; i<lists.length; i++){
            ListNode l = lists[i];
            while(l != null){
                queue.offer(l);
                l = l.next;
            }
        }

        while(!queue.isEmpty()){
            ListNode l = queue.poll();
            current.next = l;
            current = current.next;
        }
        current.next = null;

        return dummy.next;
    }
}