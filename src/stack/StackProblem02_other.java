package stack;

import java.util.HashMap;
import java.util.Stack;

public class StackProblem02_other {
    public static void main(String[] args){
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }

    private static int solution(String s) {
        // 특정 닫는 괄호를 키/ 해당 닫는 괄호의 짝을 값으로 하는 HashMap
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        // 문자열의 크기(=N)
        int n = s.length();
        int cnt = 0;
        // 원본문자열에 원본문자열 한 번 더 추가
        s += s;

        // 1. 왼쪽으로 회전시켜야 하는 횟수
        A:
        for (int i = 0; i < n; i++) {
            // 올바른 괄호인지 검증
            Stack<Character> stack = new Stack<>();
            for (int j = i; j < i + n; j++) {
                char c = s.charAt(j);
                // c가 닫는 괄호가 키인 HashMap의 키값으로 존재하지 않는 값인경우 = 여는 괄호
                if (!map.containsKey(c)) stack.push(c);
                    // 닫는 괄호인 경우
                else {
                    // 스택이 비어있거나 스택의 최상단 데이터가 쌍에 맞지 않는 경우
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }
            if (stack.isEmpty()) cnt++;
        }
        return cnt;
    }
}
