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
            // 첫 번째 노드
            ListNode A = head;
            // 두 번째 노드
            ListNode B = head.next;
            ListNode nextPair = B.next;

            // swap : B -> A
            B.next = A;
            // 임시로 다음 쌍 시작점 연결
            A.next = nextPair;

            // 이전 쌍과 연결 (여기가 빠졌던 부분)
            current.next = B;
            // 다음 루프에서 current.next = B가 A -> B 연결을 만듦
            current = A;

            head = nextPair;
        }

        // 홀수 개일 때 남은 노드 처리
        if(head != null){
            current.next = head;
        }

        return dummy.next;
    
    }
}