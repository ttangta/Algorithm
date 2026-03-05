import java.util.*;
class Solution {
    private static int N;
    private static int M;
    private static final int[] nR = {-1,1,0,0};
    private static final int[] nC = {0,0,-1,1};
    private static char[][] map;

    private static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int solution(String[] maps) {
        
        N = maps.length;
        M = maps[0].length();
        // maps의 행, 열 크기만큼 생성될 미로 크기 지정
        map = new char[N][M];
        for(int i=0; i<N; i++){
            map[i] = maps[i].toCharArray();
        }

        Node start = null, end = null, lever = null;

        // 생성된 미로 배열을 탐색하면서 시작, 끝, 레버 객체 생성
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 'S')start = new Node(i, j);
                else if(map[i][j] == 'E')end = new Node(i, j);
                else if(map[i][j] == 'L')lever = new Node(i, j);
            }
        }
        int startLever = bfs(start, lever);
        int leverEnd = bfs(lever, end);
        if(startLever == -1 || leverEnd == -1)return -1;
        else return startLever + leverEnd;
    
    }
    private static int bfs(Node start, Node end){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        // 최단 경로 값을 저장할 객체
        int[][] dist = new int[N][M];
        // 시작 점 거리 1으로 초기화
        dist[start.r][start.c] = 1;
        queue.add(start);
        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();
            // 현재 노드에서 상하좌우의 이동 검사
            for(int i=0; i<4; i++){
                int nextR = now.r + nR[i];
                int nextC = now.c + nC[i];

                // 미로 배열 밖의 이동인 경우 무시
                if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)continue;

                // 이미 방문한 노드인 경우 무시
                if(dist[nextR][nextC] > 0)continue;

                if(map[nextR][nextC] == 'X')continue;

                dist[nextR][nextC] = dist[now.r][now.c]+1;

                queue.add(new Node(nextR, nextC));

                if(nextR == end.r && nextC == end.c){
                    return dist[end.r][end.c] -1;
                }
            }
        }
        return -1;
    }
}