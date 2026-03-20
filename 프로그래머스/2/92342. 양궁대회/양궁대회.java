class Solution {
    private static int max;
    private static int[] answer;
    private static int[] apeach;
    public int[] solution(int n, int[] info) {
        max = 0;
        answer = new int[11];
        apeach = info;
        backTrack(n, new int[11], 0);
        return max == 0 ? new int[]{-1} : answer;
    }
    private static int getScore(int[] ryan){
        int score = 0;
        for(int i=0; i<=10; i++){
            if(ryan[i] + apeach[i] > 0)score += ryan[i] > apeach[i] ? 10-i : -(10-i);
        }
        return score;
    }
    private static void calculateDiff(int[] ryan){
        int score = getScore(ryan);
        if(max < score){
            max = score;
            answer = ryan.clone();
        }
        else if(max > 0 && max == score){
            for(int i=10; i>=0; i--){
                if(answer[i] != ryan[i]){
                    if(answer[i] < ryan[i]){
                        answer = ryan.clone();
                    }
                    break;
                }
            }
        }
    }
    private static void backTrack(int arrow, int[] ryan, int idx){
        if(arrow == 0){
            calculateDiff(ryan);
            return;
        }
        for(int i=idx; i<=10; i++){
            int cnt = Math.min(arrow, apeach[i]+1);
            ryan[i] = cnt;
            backTrack(arrow - cnt, ryan, i+1);
            ryan[i] = 0;
        }
    }
}