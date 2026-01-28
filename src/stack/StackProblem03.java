package stack;

import java.util.Stack;

public class StackProblem03 {

    public static void main(String[] args){
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));

    }

    private static int solution(String s){
        int result = 0;
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<n ; i++){
            char c = s.charAt(i);
            // 초기 스택은 비어있으므로 비어있는 경우 일단 push 후 반복문 건너뛰기
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }

            // c의 값과 스택의 가장 최근의 데이터 비교 같으면 pop(), 다른 경우 push()
            if(stack.peek().equals(c)){
                stack.pop();
            }
            else stack.push(c);
        }
        if(stack.isEmpty())result = 1;
        return result;
    }
}
