import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        dp[0] = new int[]{triangle[0][0]};
        dp[1] = new int[triangle[1].length];
        for(int i=0; i<triangle[1].length; i++){
            dp[1][i] = dp[0][0] + triangle[1][i];
        }
        for(int i=2; i<triangle.length; i++){
            dp[i] = new int[triangle[i].length];
            for(int j=0; j<triangle[i].length; j++){
                if(j==0){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }
                else if(j==triangle[i].length-1){
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }

            }
        }


        return Arrays.stream(dp[triangle.length-1]).max().getAsInt();
    }
}