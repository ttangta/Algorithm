import java.util.*;
class Solution {
    private static final int[] nr = {-1, 1, 0, 0};
    private static final int[] nc = {0, 0, -1, 1};
    private static char[][] map;
    private static int n;
    private static int m;
    private static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        // 미로 생성
        for(int i=0; i<n ; i++){
            map[i] = maps[i].toCharArray();
        }
        
        // 미로 내 start, end, lever 지점 찾기
        Node start = null, end = null, lever = null;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 'S')start = new Node(i, j);
                else if(map[i][j] == 'E')end = new Node(i, j);
                else if(map[i][j] == 'L')lever = new Node(i, j);
            }
        }
        
        // start -> lever 최단거리
        int startLever = bfs(start, lever);
        // lever -> end 최단 거리
        int leverEnd = bfs(lever, end);
        
        if(startLever == -1 || leverEnd == -1)return -1;
        else return startLever + leverEnd;
        
        // bfs 함수에서 start -> lever 또는 lever -> end 이동 불가 시 -1
    }
    
    // BFS 알고리즘 메서드 : 최단, 최소 비용 
    private static int bfs(Node start, Node end){
        // bfs : Queue 자료구조 사용
        ArrayDeque<Node> queue = new ArrayDeque<>();
        // 현재 -> 다음 이동 시 소요되는 시간 및 비용을 담는 2차원 배열 "배열 값 != 0" <- 이미 방문한 경로
        int[][] dist = new int[n][m];
        dist[start.r][start.c] = 1;
        queue.addLast(start);
        
        while(!queue.isEmpty()){
            Node now = queue.pollFirst();
            
            // 현재 지점에서 상 하 좌 우 이동 경우 비교
            for(int i=0; i<4; i++){
                // 각 이동에 대한 좌표 값
                int nextR = now.r + nr[i];
                int nextC = now.c + nc[i];
                
                // 이동 할 다음 좌표의 값이 하나라도 미로 범위를 벗어나면 이동 불가 (해당 좌표 이동 무시)
                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m)continue;
                
                // 다음 좌표로 이동 시 해당 좌표의 값이 'X' 즉 벽인 경우 이동 불가 
                if(map[nextR][nextC] == 'X')continue;
                
                // 이동한 좌표가 이미 방문한 이력이 존재하는 경우 bfs에서는 재방문을 하지 않기 때문에 무시
                if(dist[nextR][nextC] > 0)continue;
                
                // 위의 모든 이동이 무시되는 상황이 아닌경우 map[nextR][nextC] = 현재에서 이동 된 정점
                // 현재에서 가장 가까운 위치(현재 지점 + 1)
                dist[nextR][nextC] = dist[now.r][now.c] + 1;
                
                // 다음 노드에서 이동 가능한 가장 가까운 위치에 존재하는 노드를 검증한기 위해 Queue에 Node 추가
                queue.addLast(new Node(nextR, nextC));
                
                // 만약 현재에서 다음으로 이동될 좌표의 값이 end의 좌표 값과 같으면 위에서 이미 1이 증가 되어 있기 때문에 문제에 맞추기 위해 dist 배열에서 -1 값을 한 뒤 리턴
                if(nextR == end.r && nextC == end.c){
                    return dist[end.r][end.c] - 1;
                }
            }
        }
        // start -> end 까지 이동을 반복하는 동안 nextR, nextC 가 end의 좌표에 도달 못한 경우 즉 이동이 막힌 경우는 -1 리턴
        return -1;
    }
}