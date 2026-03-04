import java.util.*;
class Solution {
    private static final int[] rx = {0,0,-1,1};
    private static final int[] ry = {-1,1,0,0};
    
    private static class Node{
        int r, c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int solution(int[][] maps) {
        // 행
        int N = maps.length;
        // 열
        int M = maps[0].length;
        
        // 각 노드의 최단 거리를 지정하는 배열
        int[][] dist = new int[N][M];
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(0,0));
        dist[0][0] = 1;
        
        // BFS 
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            for(int i=0; i<4; i++){
                int nr = now.r + ry[i];
                int nc = now.c + rx[i];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M)continue;
                
                if(maps[nr][nc] == 0)continue;
                
                if(dist[nr][nc] == 0){
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                    queue.addLast(new Node(nr, nc));
                }
            }
        }
        return dist[N-1][M-1] == 0 ? -1 : dist[N-1][M-1];
    }
}