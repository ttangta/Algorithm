import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int result = 0;
        int n = board.length;
        int m = moves.length;
        
        for(int i=0; i<m; i++){
            moves[i] -= 1;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        M:for(int x : moves){
            for(int i=0; i<n; i++){
                int target = board[i][x];
                if(target !=0){
                    if(stack.isEmpty() || !stack.peek().equals(target))stack.push(target);
                    else{
                        stack.pop();
                        result += 2;
                    }
                    board[i][x] = 0;
                    continue M;
                }
            }
        }
        return result;
    }
}