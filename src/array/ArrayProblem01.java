package array;

import java.util.ArrayList;
import java.util.Arrays;

// 프로그래머스 : 두 개 뽑아서 더하기
// 풀긴 했지만 반복문 설정을 좀 더 간단하게 구현하는 방법을 생각하지 못했음
public class ArrayProblem01 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(s3(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(s3(new int[]{5, 0, 2, 7})));
    }
    public static int[] s3(int[] arr){
        ArrayList<Integer> sumNumbers = new ArrayList<Integer>();
        for(int i = 0 ; i < arr.length-1 ; i ++){
            for(int j = i+1 ; j < arr.length ; j++){
                // j반복문이 도는 동안 매번 arr[j]를 더할 arr[i] 값 초기화
                int sum = arr[i];

                // arr[j]를 더함
                sumNumbers.add(sum+arr[j]);
            }
        }
        return sumNumbers.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
    }
}
