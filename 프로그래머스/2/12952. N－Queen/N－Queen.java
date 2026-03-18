class Solution {
    private static boolean[] width;
    private static boolean[] lDiagonal;
    private static boolean[] rDiagonal;
    private static int N;
    public int solution(int n) {
        width = new boolean[n];
        lDiagonal = new boolean[n*2];
        rDiagonal = new boolean[n*2];
        N = n;
        int answer = backTrack(0);
        return answer;
    }
    private static int backTrack(int y){
        int ans = 0;
        if(y == N){
            ans++;
        }
        else{
            for(int i=0; i<N; i++){
                if(width[i] || lDiagonal[i+y] || rDiagonal[i-y+N])continue;
                width[i] = lDiagonal[i+y] = rDiagonal[i-y+N] = true;
                ans += backTrack(y+1);
                width[i] = lDiagonal[i+y] = rDiagonal[i-y+N] = false;
            }
        }
        return ans;
    }
}