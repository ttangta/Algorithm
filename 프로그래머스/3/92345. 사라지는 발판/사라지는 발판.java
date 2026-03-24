import java.util.*;
class Solution {
    private static int[][] Board;
    private static int ROW, COL;
    private static boolean[][] visited;
    private static final int[][] MV = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int solution(int[][] board, int[] alpha, int[] beta) {
        Board = board;
        ROW = board.length;
        COL = board[0].length;
        visited = new boolean[ROW][COL];
        return backTrack(alpha, beta, 0).step;
    }
    
    private static class Result{
        boolean win;
        int step;
        public Result(boolean win, int step){
            this.win = win;
            this.step = step;
        }
    }
    
    private static boolean isValid(int row, int col){
        return 0 <= row && row < ROW && 0 <= col && col < COL;
    }
    
    private static Result backTrack(int[] alpha, int[] beta, int step){
        int[] now = step%2==0?alpha:beta;
        boolean canMove = false;
        boolean isOpponentWinner = true;
        ArrayList<Integer> winStep = new ArrayList<>();
        ArrayList<Integer> loseStep = new ArrayList<>();
        
        for(int i=0; i<4; i++){
            int nr = now[0] + MV[i][0];
            int nc = now[1] + MV[i][1];
            
            if(isValid(nr, nc) && !visited[nr][nc] && Board[nr][nc] == 1){
                canMove = true;
                if(alpha[0] == beta[0] && alpha[1] == beta[1]){
                    return new Result(true, step+1);
                }
                visited[now[0]][now[1]] = true;
                
                Result result = step%2==0?
                    backTrack(new int[]{nr, nc}, beta, step+1):
                    backTrack(alpha, new int[]{nr, nc}, step+1);
                
                visited[now[0]][now[1]] = false;
                isOpponentWinner &= result.win;
                if(result.win)winStep.add(result.step);
                else loseStep.add(result.step);
            }
        }
        if(!canMove)return new Result(false, step);
        if(isOpponentWinner)return new Result(false, winStep.stream().max(Comparator.comparingInt(o -> o)).get());
        return new Result(true, loseStep.stream().min(Comparator.comparingInt(o -> o)).get());
    }
}