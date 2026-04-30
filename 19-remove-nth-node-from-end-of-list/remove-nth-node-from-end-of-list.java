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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 원본 head는 그대로 반환으로 사용해야하기 떄문에 복사본 생성
        ListNode clone = head;
        int idx = 0;
        // 1. 리스트의 크기 측정
        while(clone != null){
            idx++;
            clone = clone.next;
        }

        // 2. 뒤에서 n번째 노드를 제거하기 위해서는 뒤에서 n-1번 노드의 수정 필요 -> 수정해야하는 노드의 위치를 나타내는 변수
        int target = idx - n;

        // 만약 0번째 노드의 수정이 필요한 경우 단순 매개변수로 전달받은 head의 next 부터 그대로 출력하면 됨
        if(target == 0)return head.next;
        
        // target번 노드를 수정하기 위해 idx와, clone을 다시 최초의 값으로 초기화
        idx = 0;
        clone = head;
        while(clone != null){
            idx++;
            if(idx == target){
                clone.next = clone.next.next;
                break;
            }
            clone = clone.next;
        }
        return head;
    }
}