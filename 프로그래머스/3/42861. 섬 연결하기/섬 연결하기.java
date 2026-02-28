import java.util.*;

class Solution {
    private static int[] parent;
    private static int find(int x){
        if(parent[x] == x)return x;
        return parent[x] = find(parent[x]);
    }
    private static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        parent[rootY] = rootX;
    }
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0; i<n; i++)parent[i] = i;
        
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        int edges = 0;
        int answer =0;
        for(int[] edge : costs){
            if(edges == n-1)break;
            if(find(edge[0]) != find(edge[1])){
                union(edge[0], edge[1]);
                edges++;
                answer += edge[2];
            }
        }
        return answer;
    }
}