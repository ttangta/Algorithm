import java.util.*;
class Solution {
    private static int answer;
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        adjList = new ArrayList[n];
        
        // 인접 노드 저장
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(i==j)continue;
                if(computers[i][j] == 1)adjList[i].add(j);
            }
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                dfs(i);
            }
        }
        return answer;
    }
    private static void dfs(int now){
        visited[now] = true;
        for(int i : adjList[now]){
            if(!visited[i])dfs(i);
        }
    }
}