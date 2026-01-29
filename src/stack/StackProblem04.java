package stack;

import java.util.Arrays;
import java.util.Stack;

// 잘못된 접근 O(N^2) 방식을 통한 문제 해결 버전
public class StackProblem04 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,2,3})));
    }

    private static int[] solution(int[] prices){
        int n = prices.length;
        int[] result = new int[n];
        for(int i =0; i<n-1; i++){
            Stack<Integer> stack = new Stack<>();
            for(int j=i+1; j<n; j++){
                stack.push(prices[j]);
            }
            int cnt = 0;
            for(int j=(n-1); j >i; j--){
                int top = stack.pop();
                if(prices[i] <= top)cnt++;
            }
            result[i] = cnt;
        }
        return result;
    }
}
