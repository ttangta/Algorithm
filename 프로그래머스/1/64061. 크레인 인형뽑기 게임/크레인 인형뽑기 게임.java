import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer>[] stacks = new Stack[board[0].length];
        
        for(int i=0; i<board[0].length; i++)stacks[i] = new Stack<>();
        
        for(int i=0; i<board[0].length; i++){
            for(int j=(board.length-1); j>=0; j--){
                if(board[j][i] == 0)continue;
                stacks[i].push(board[j][i]);
            }
        }
        
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int x : moves){
            x -= 1;
            if(stacks[x].isEmpty())continue;
            else{
                int target = stacks[x].pop();
                if(stack.isEmpty() || stack.peek() != target)stack.push(target);
                else{
                    stack.pop();
                    answer += 2;
                }
                
            }
        }
        return answer;
        
    }
}