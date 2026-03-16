class Solution {
    private static boolean[] width;
    private static boolean[] ldDiagonal;
    private static boolean[] rdDiagonal;
    private static int N;
    public int solution(int n) {
        N = n;
        width = new boolean[n];
        ldDiagonal = new boolean[n*2];
        rdDiagonal = new boolean[n*2];
        return backTrack(0);
    }
    private int backTrack(int y){
        int answer = 0;
        if(y == N)answer++;
        else{
            for(int i=0; i<N; i++){
                if(width[i] || ldDiagonal[i+y] || rdDiagonal[i-y+N])continue;
                width[i] = ldDiagonal[i+y] = rdDiagonal[i-y+N] = true;
                answer += backTrack(y+1);
                width[i] = ldDiagonal[i+y] = rdDiagonal[i-y+N] = false;
            }
        }
        
        return answer;
    }
}