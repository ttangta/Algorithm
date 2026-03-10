import java.util.*;

class Solution {
    private static final int[][] D = {{0,-1},{-1,0},{0,1},{1,0}};
    private static int N;
    private static int[][][] visited;
    private static class Node{
        int r, c, dir, cost;
        public Node(int r, int c, int dir, int cost){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }
    }
    public int solution(int[][] board) {
        N = board.length;
        visited = new int[N][N][4];
        int answer = Integer.MAX_VALUE;
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(0, 0, -1, 0));
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            for(int i=0; i<4; i++){
                int nr = now.r + D[i][0];
                int nc = now.c + D[i][1];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || (nr==0 && nc==0) || board[nr][nc] == 1)continue;
                
                int newCost;
                if(now.dir == -1 || (i - now.dir)%2 == 0)newCost = now.cost + 100;
                else newCost = now.cost + 600;
                
                if(nr == N-1 && nc == N-1)answer = Math.min(answer, newCost);
                else if(visited[nr][nc][i] == 0 || visited[nr][nc][i] > newCost){
                    visited[nr][nc][i] = newCost;
                    queue.addLast(new Node(nr, nc, i, newCost));
                }
            }
        }
        return answer;
    }
}