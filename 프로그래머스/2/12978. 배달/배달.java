import java.util.*;

class Solution {
    private static class Node{
        int dest, cost;
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }
    private static ArrayList<Node>[] adjList;
    public int solution(int N, int[][] road, int K) {
        // 인접 리스트 생성
        adjList = new ArrayList[N+1];
        for(int i=1; i<=N; i++)adjList[i] = new ArrayList<>();
        for(int[] arr : road){
            adjList[arr[0]].add(new Node(arr[1], arr[2]));
            adjList[arr[1]].add(new Node(arr[0], arr[2]));
        }
        
        // 최소 비용 저장 배열
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // Node의 cost 값 기준 오름차순 정렬 큐
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(dist[now.dest] < now.cost)continue;
            
            for(Node next : adjList[now.dest]){
                if(dist[next.dest] > now.cost + next.cost){
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        int answer = 0;
        for(int i=1; i<=N; i++){
            if(dist[i] <= K)answer++;
        }
        return answer;
    }
}