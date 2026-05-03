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
            ListNode list = (lists[i] != null)?lists[i] : null;
            if(list != null)queue.offer(list);
        }
        while(!queue.isEmpty()){
            ListNode list = queue.poll();
            current.next = list;
            current = current.next;
            if(list.next != null){
                queue.offer(list.next);
            }
        }
        current.next = null;
        return dummy.next;
    }
}