class Solution
{
    public int solution(int [][]board)
    {
        int row = board.length;
        int col = board[0].length;
        int[][] dp = new int[row][col];
        dp[0] = board[0].clone();
        for(int i=1; i<row; i++)dp[i][0] = board[i][0];
        
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(board[i][j] == 1){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++)answer = Math.max(answer, dp[i][j]);
        }
        return answer * answer;
    }
}