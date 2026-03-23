import java.util.*;
class Solution {
    private static final int[][] MV = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[][] Board;
    private static int ROW, COL;
    private static boolean[][] visited;
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Board = board;
        ROW = board.length;
        COL = board[0].length;
        visited = new boolean[ROW][COL];
        return backTrack(aloc, bloc, 0).step;
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
    private static Result backTrack(int[] aloc, int[] bloc, int step){
        int[] now = step%2==0?aloc:bloc;
        boolean canMove = false;
        boolean isOpponentWinner = true;
        ArrayList<Integer> winStep = new ArrayList<>();
        ArrayList<Integer> loseStep = new ArrayList<>();
        for(int i=0; i<4; i++){
            int nr = now[0] + MV[i][0];
            int nc = now[1] + MV[i][1];
            
            // 현재에서 i번째 방향 이동이 가능한 경우
            if(isValid(nr, nc) && !visited[nr][nc] && Board[nr][nc]==1){
                canMove = true;
                
                // 만약 A,B가 같은 좌표에 있을 경우 A가 선공으로 승리
                if(aloc[0] == bloc[0] && aloc[1] == bloc[1])return new Result(true, step+1);
                
                // now 좌표의 방문 이력을 true로 변경
                visited[now[0]][now[1]] = true;
                Result result = step%2==0?backTrack(new int[]{nr, nc}, bloc, step+1):backTrack(aloc, new int[]{nr, nc}, step+1);
                visited[now[0]][now[1]] = false;
                
                // 상대 승리 -> 모든 방향에 대한 상대의 결과가 승리인 경우
                isOpponentWinner &= result.win;
                
                // 상대 승리 시 
                if(result.win)winStep.add(result.step);
                else loseStep.add(result.step);
            }
        }
        // 상하좌우 모든 방향으로 이동할 수 없는 경우 이동 불가 + 패배
        if(!canMove)return new Result(false, step);
        if(isOpponentWinner)return new Result(false, winStep.stream().max(Comparator.comparingInt(o -> o)).get());
        return new Result(true, loseStep.stream().min(Comparator.comparingInt(o -> o)).get());
    }
}