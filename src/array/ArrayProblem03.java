package array;

import java.util.Arrays;

// 프로그래머스 : 행렬의 곱셈 (오답)
// 행렬 곱셈 : 두 개의
public class ArrayProblem03 {
    public static void main(String[] args){
        int [][] a1 = {{1,4}, {3,2}, {4,1}};
        int [][] b1 = {{3,3},{3,3}, {3,3}};
        int[][] r1 = s5(a1, b1);

        int [][] a2 = {{2,3,2}, {4,2,4}, {3,1,4}};
        int [][] b2 = {{5,4,3}, {2,4,1}, {3,1,1}};
        int[][] r2 = s5(a2, b2);


        int[][] a3 = {{1,2,3,4}, {5,6,7,8}};
        int[][] b3 = {{1,2}, {3,4}, {5,6}, {7,8}};
        int[][] r3 = s5(a3,b3);

        for(int i = 0 ; i < r1.length ; i++)System.out.print(Arrays.toString(r1[i]));
        System.out.println();
        for(int i = 0 ; i < r2.length ; i++)System.out.print(Arrays.toString(r2[i]));
        System.out.println();
        for(int i = 0 ; i < r3.length ; i++)System.out.print(Arrays.toString(r3[i]));
    }
    public static int[][] s5(int[][] a, int[][] b){
        // a의 행/열
        int ar = a.length, ac = a[0].length;
        // b의 행/열
        int br = b.length, bc = b[0].length;
        // 결과 2차원 배열의 크기 = a의 행 수 * b의 열 수
        int[][] result = new int[ar][bc];

        // 1. 결과의 행
        for(int i = 0 ; i < ar; i++){
            // 2. 결과 열
            for(int j = 0 ; j < bc ; j++){
                // 3. 결과 2차원 배열의 한 칸을 채우기 위한 연산
                for(int k = 0 ; k < ac ; k++){
                    result[i][j] += (a[i][k] * b[k][j]);
                }
            }
        }
        return result;
    }
}
