package stack;

import java.util.Arrays;
import java.util.Stack;

public class StackProblem04_ReferenceAnswer {

    public static void main(String[] args){
        solution(new int[]{1,2,3,2,3});
    }

    private static void solution(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        // arr의 인덱스 값을 담을 Stack 객체
        Stack<Integer> stack = new Stack<>();
        // 스택의 최초값은 비어있기 때문에 0번 인덱스 담기
        stack.push(0);

        // arr[0]과 arr[1]번의 값부터 비교하기 위해 i는 1부터 시작
        for (int i = 1; i < n; i++) {
            // 스택이 비어있지 않으면서 arr[stack.peek()] 즉, 이전의 값이 현재 값보다 큰 경우동안 반복
            // 가격이 떨어진 경우
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int j = stack.pop();
                result[j] = i - j;
            }
            // 현재 인덱스 번호를 스택에 누적
            stack.push(i);
        }

        // 길이가 정해지지 않은 부분에 길이 지정
        while (!stack.isEmpty()) {
            int j = stack.pop();
            result[j] = (n - 1) - j;
        }
        System.out.println(Arrays.toString(result));
    }
}
