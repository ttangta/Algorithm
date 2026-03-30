import java.util.*;
class Solution {
    private static HashMap<String, int[]> MV;
    private static void buildOffSet(){
        MV = new HashMap<>();
        MV.put("up", new int[]{1, 0});
        MV.put("down", new int[]{-1, 0});
        MV.put("left", new int[]{0, -1});
        MV.put("right", new int[]{0, 1});
    }
    private static int ROW, COL;
    private static int initX, initY;
    private static class Coordinate{
        int x, y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static boolean isValid(int row, int col){
        return 0 <= row && row < ROW && 0 <= col && col < COL;
    }
    
    public int[] solution(String[] keyinput, int[] board) {
        // offSet 생성
        buildOffSet();

        // 좌표관점과 배열 관점의 차이 구분해야함 board[x,y] = arr[y][x]
        int[] answer = new int[2];
        ROW = board[1];
        COL = board[0];
        int[][] arr = new int[ROW][COL];

        int r = ROW/2;
        int c = COL/2;

        initX = COL/2;
        initY = ROW/2;

        Coordinate current = new Coordinate(c-initX, r-initY);
        for(String s : keyinput){
            int nr = r + MV.get(s)[0];
            int nc = c + MV.get(s)[1];
            if(!isValid(nr, nc))continue;

            r = nr;
            c = nc;
            current.x = c-initX;
            current.y = r-initY;
        }

        answer[0] = current.x;
        answer[1] = current.y;
        return answer;
    }
}