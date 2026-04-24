class Solution {
    public boolean isMatch(String s, String p) {
        // s의 길이
        int m = s.length();
        // p의 길이
        int n = p.length();

        // 메모이제이션 : dp[0][0] = s가 빈문자열, p가 빈문지열인 경우 매치 결과 
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int j=2; j<=n; j++){
            if(p.charAt(j-1) == '*')dp[0][j] = dp[0][j-2];
        }

        // dp 채우기
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){    
                // 현재 s의 문자
                char sc = s.charAt(i-1);
                // 현재 p의 문자
                char pc = p.charAt(j-1);

                // 만약 p의 문자가 '*' 인경우 두 가지 경우가 존재 1. 해당 패턴 0번 사용(s 그대로, p 두 칸 이동), 2. 해당 패턴 1번 사용 (s 한 칸 이동, p 그대로)
                if(pc == '*'){
                    boolean zeroMath = dp[i][j-2];
                    boolean oneMatch = (sc == p.charAt(j-2) || p.charAt(j-2) =='.') && dp[i-1][j];
                    dp[i][j] = zeroMath || oneMatch;
                }
                else{
                    dp[i][j] = (sc == pc || pc == '.') && dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}