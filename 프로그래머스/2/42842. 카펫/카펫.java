class Solution {
    public int[] solution(int red, int white) {
        int[] answer = new int[2];
        // 1. 카펫(사각형)의 총 넓이
        int total = red + white;

        // 2. 사각형의 row 범위
        for(int row = 3 ; row <= (int)Math.sqrt(total); row++){
            // 사각형의 넓이 = row * col
            int col = (int)total/row;
            if(row * col == total && (col-2)*(row-2) == white){
                answer[0] = col;
                answer[1] = row;
                return answer;
            }
        }

        return answer;
    }
}