import java.util.*;
class Solution {
    private static final int[] NR = {0, -1, 0, 1};
    private static final int[] NC = {-1, 0, 1, 0};
    private static class Node{
        int r;
        int c;
        int direction;
        int cost;
        public Node(int r, int c, int direction, int cost){
            this.r = r;
            this.c = c;
            this.direction = direction;
            this.cost = cost;
        }
    }
    private static int[][][] visited;
    private static int N, answer;
    private static boolean isValid(int nr, int nc){
        return 0 <= nr && nr < N && 0 <= nc && nc < N;
    }
    private static boolean isBlocked(int[][] board, int nr, int nc){
        return !isValid(nr, nc) || (nr == 0 && nc == 0) || board[nr][nc] == 1;
    }
    private static int calculateCost(int direction, int preDirection, int cost){
        if(preDirection == -1 || (direction - preDirection)%2 == 0)return cost += 100;
        else return cost += 600;
    }
    private static boolean isShouldUpdate(int nr, int nc, int direction, int newCost){
        if(visited[nr][nc][direction] == 0 || visited[nr][nc][direction] > newCost)return true;
        else return false;
    }
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        N = board.length;
        visited = new int[N][N][4];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(0, 0, -1, 0));
        
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            
            // 현재 위치의 방향 이동
            for(int i=0; i<4; i++){
                int nr = now.r + NR[i];
                int nc = now.c + NC[i];
                if(isBlocked(board, nr, nc))continue;
                
                int newCost = calculateCost(i, now.direction, now.cost);
                
                if(nr == N-1 && nc == N-1)answer = Math.min(answer, newCost);
                else if(isShouldUpdate(nr, nc, i, newCost)){
                    visited[nr][nc][i] = newCost;
                    queue.addLast(new Node(nr, nc, i, newCost));
                }
            }
        }
        return answer;
    }
}