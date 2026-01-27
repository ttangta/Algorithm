package stack;
import java.util.Stack;
public class StackProblem01 {
    public static void main(String[] args){
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    private static boolean solution(String srt){
        // 스택객체 생성
        Stack<Character> stack = new Stack<>();

        // 문자열을 돌며 "열린 괄호"일 경우 스택에 push() "닫힌 괄호"인 경우 Stack이 비어있다면 바로 false 리턴, Stack이 비어있지 않는다면 Stack의 데이터 pop()
        for(char x : srt.toCharArray()){
            if(x == '(')stack.push(x);
            else{
                if(stack.isEmpty())return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
