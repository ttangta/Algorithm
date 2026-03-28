import java.util.*;
class Solution {
    private static final int[][] MV = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int N;
    private static boolean[][] visited;
    
    private static class Node{
        int i, j, cost;
        public Node(int i, int j, int cost){
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }
    
    private static boolean isValid(int i, int j){
        return 0 <= i && i < N && 0 <= j && j < N;
    }
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        N = land.length;
        visited = new boolean[N][N];
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(0, 0, 0));
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.i][now.j])continue;
            visited[now.i][now.j] = true;
            answer += now.cost;
            
            for(int i=0; i<4; i++){
                int ni = now.i + MV[i][0];
                int nj = now.j + MV[i][1];
                if(isValid(ni, nj)){
                    int tempCost = Math.abs(land[now.i][now.j] - land[ni][nj]);
                    int newCost = tempCost>height?tempCost:0;
                    pq.add(new Node(ni, nj, newCost));
                }
            }
        }
        return answer;
    }
}