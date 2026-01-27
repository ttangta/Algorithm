package stack;
import java.util.Stack;
// 10진수 -> 2진수로 변환
public class CustomProblem01 {
    public static void main(String[] args){
        System.out.println(solution(10));
        System.out.println(solution(27));
        System.out.println(solution(12345));
    }


    private static String solution(int n){
        // n%2의 값을 저장하는 Stack 객체
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // n > 0 큰 동안 n을 절반으로 나눔 O(logN)
        while(n > 0){
            stack.push(n%2);
            n /= 2;
        }

        // Stack.isEmpty() == false인 동안 Stack.pop()
        while(!stack.isEmpty())sb.append(stack.pop());
        return sb.toString();
    }
}
