class Solution {
    private static boolean[]visited;
    private static int answer;
    private static int[][] Dungeons;
    public int solution(int k, int[][] dungeons) {
        Dungeons = dungeons;
        visited = new boolean[Dungeons.length];
        answer = 0;
        backTrack(k, 0);
        return answer;
    }
    private static void backTrack(int k, int cnt){
        for(int i=0; i<Dungeons.length; i++){
            if(!visited[i] && k >= Dungeons[i][0]){
                visited[i] = true;
                backTrack(k - Dungeons[i][1], cnt+1);
                answer = Math.max(answer, cnt+1);
                visited[i] = false;
            }
        }
    }
}