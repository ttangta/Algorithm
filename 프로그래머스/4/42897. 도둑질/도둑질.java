class Solution {
    public int solution(int[] money) {
        // 집의 갯수
        int n = money.length;

        // 0 접근한 경우 -> (N-1) 접근 불가
        int[] dp1 = new int[n];

        // 0번 시작 dp1 초기화 (0, 1번값 초기화 가능)
        dp1[0] = money[0];
        // 0번 시작 시 1번 접근 불가
        dp1[1] = dp1[0];

        // 범위(2 ~ (N-1)이전)
        for(int i=2; i<n-1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }

        // 0번 부터 시작하지 않는 경우 -> (N-1) 접근 가능
        int[] dp2 = new int[n];
        dp2[1] = money[1];
        for(int i=2; i<n; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }

        return Math.max(dp1[n-2], dp2[n-1]);
    }
}