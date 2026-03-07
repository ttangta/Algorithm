import java.util.*;
class Solution {
    // 상하좌우 이동 시 L = 0, U = 1, R = 2, D = 3  
    // 이후 for(int i=0; i<4; i++)에서 i의 값을 통해 방향성 결정
    private static final int[] nr = {0, -1, 0, 1};
    private static final int[] nc = {-1, 0, 1, 0};
    
    // 행, 열, 이전->현재 진입 방향(1~4), 현재 가격을 필드로 가지는 Node 클래스 생성
    public static class Node{
        int r, c, direction, cost;
        public Node(int r, int c, int direction, int cost){
            this.r = r;
            this.c = c;
            this.direction = direction;
            this.cost = cost;
        }
    }
    private static int N;
    // 현재 노드의 좌표 + 방향까지 함께 정보를 하는 3차원 배열 객체
    private static int[][][] visited;
    // 상하좌우 이동 가능 여부 판단 메서드
    private static boolean isValid(int nextR, int nextC){
        return 0 <= nextR && nextR < N && 0 <= nextC && nextC < N;
    }
    // isValid + board의 벽 + 시작점(0,0) 으로 되돌아오는 이동 검증
    private static boolean isBlocked(int[][]board,int nextR, int nextC){
        return (nextR == 0 && nextC == 0) || !isValid(nextR, nextC) || board[nextR][nextC] == 1;
    }
    // 이전 방향과 현재 방향을 비교하여 비용 계산 메서드 
    // 현재 노드에서 이동 가능한 방향을 찾는 시점에서 현재 노드는 => 이전으로 바뀜
    private static int calculateCost(int direction, int preDirection, int cost){
        if(preDirection == -1 || (preDirection-direction)%2 ==0)return cost + 100;
        else return cost + 600;
    }
    // 주어진 좌표와 방향이 아직 방문하지 않았거나 넘어온 새 비용이 더 작다면 업데이트
    private static boolean isShouldUpdate(int nextR, int nextC, int direction, int cost){
        return visited[nextR][nextC][direction] == 0 ||
            visited[nextR][nextC][direction] > cost;
    }
    
    public int solution(int[][] board) {
        N = board.length;
        visited = new int[N][N][4];
        int answer = Integer.MAX_VALUE;
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(0,0,-1,0));
        
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            for(int i=0; i<4; i++){
                int nextR = now.r + nr[i];
                int nextC = now.c + nc[i];
                if(isBlocked(board, nextR, nextC))continue;
                
                int newCost = calculateCost(i, now.direction, now.cost);
                
                if(nextR == N-1 && nextC == N-1)answer = Math.min(answer, newCost);
                else if(isShouldUpdate(nextR, nextC, i, newCost)){
                    visited[nextR][nextC][i] = newCost;
                    queue.addLast(new Node(nextR, nextC, i, newCost));
                }
            }
        }
        return answer;
    }
}