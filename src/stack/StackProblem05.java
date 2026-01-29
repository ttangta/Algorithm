package stack;

import java.util.Stack;

public class StackProblem05 {

    public static void main(String[] args){
        System.out.println(solution(new int[][]{{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
        System.out.println(solution(new int[][]{{0,0,0,0},{0,0,0,0},{2,0,0,0},{1,1,3,4}}, new int[]{1,3,2,1,4}));
    }

    private static int solution(int[][] board, int[] moves){
        int result = 0;
        int n= board.length, m=moves.length;
        for(int i=0; i<m; i++){
            moves[i] -= 1;
        }
        Stack<Integer> stack = new Stack<>();

        M:for(int x : moves){
            for(int i=0; i<n; i++){
                // 행을 이동하면서 값 선택
                int target = board[i][x];
                // 값이 0이 아닌 경우
                if(target != 0){
                    // 상황에 따라 push 또는 pop
                    if(stack.isEmpty() || !stack.peek().equals(target))stack.push(target);
                    else{
                        stack.pop();
                        result += 2;
                    }
                    // 한 번 선택된 배열의 값은 0으로 변경시켜줌(동일 x 상황에서 한 번 선택된 값은 이미 스택에 존재하거나 pop 됬음을 명시)
                    board[i][x] = 0;
                    continue M;
                }
            }
        }

        return result;
    }
}
