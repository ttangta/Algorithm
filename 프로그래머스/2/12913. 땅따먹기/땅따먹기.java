import java.util.*;
class Solution {
    private static final int[][] isValid = {{1,2,3}, {0,2,3}, {0,1,3},{0,1,2}};
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];
        dp[0] = land[0].clone();
        
        for(int i=1; i<n; i++){
            for(int j=0; j<4; j++){
                dp[i][j] = land[i][j] + Math.max(dp[i-1][isValid[j][0]], Math.max(dp[i-1][isValid[j][1]], dp[i-1][isValid[j][2]]));
            }
        }
        return Arrays.stream(dp[n-1]).max().getAsInt();
    }
}