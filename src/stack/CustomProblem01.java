package stack;
import java.util.Stack;
public class CustomProblem01 {
    public static void main(String[] args){
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
    private static boolean solution(String str){
        // 스택 객체 생성
        Stack<Character> stack = new Stack<>();

        // 매개변수로 전달받은 문자열의 길이만큼 반복문 수행 O(N)
        for(int i=0; i<str.length(); i++){
            // 만약 str의 i번째 문자가 "열린 괄호"인 경우 스택에 push
            if(str.charAt(i) == '(')stack.push(str.charAt(i));
            // 만약 str의 i번째 문자가 "닫힌 괄호" 이면서
            else{
                // 스택에 데이터가 존재하지 않을 경우는 올바른 괄호가 아님으로 바로 false 리턴
                if(stack.isEmpty())return false;
                // 스택에 데이터가 존재한다면 스택에 존재하는 가장 마지막 데이터 하나 pop
                else stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
