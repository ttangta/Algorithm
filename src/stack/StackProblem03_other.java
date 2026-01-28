package stack;

import java.util.Stack;

public class StackProblem03_other {

    public static void main(String[] args){
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    private static int solution(String s){
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek().equals(c))stack.pop();
            else stack.push(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
