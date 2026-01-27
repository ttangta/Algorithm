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
            if(str.charAt(i) == '(')stack.push(str.charAt(i));
            else{
                if(stack.isEmpty())return false;
                else stack.pop();
            }
        }
        if(!stack.isEmpty())return false;
        return true;
    }
}
