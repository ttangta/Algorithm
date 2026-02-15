import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int a1r = arr1.length;
        int a1c = arr1[0].length;
        int a2r = arr2.length;
        int a2c = arr2[0].length;
        
        int[][] answer = new int[a1r][a2c];
        
        for(int i=0; i<a1r; i++){
            for(int j=0; j<a2c; j++){
                for(int k=0; k<a1c; k++)answer[i][j] += (arr1[i][k] * arr2[k][j]);
            }
        }
        
        return answer;
    }
}