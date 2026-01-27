package stack;

import java.util.Stack;

public class StackProblem02 {
    public static void main(String[] args){
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }

    private static int solution(String s){
        int n = s.length();
        char[] arr = s.toCharArray();
        int cnt = 0;

        // 0 <= x < s길이 (왼쪽으로 회전 횟수)
        for(int i=0; i<n; i++){
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            char tmp = arr[0];
            // 올바른 괄호인지 먼저 검증
            for(char x : arr){
                // x가 "열린 괄호"인 경우 스택에 추가
                if(x == '(' || x == '{' || x == '[')stack.push(x);
                else{
                    // x가 "닫힌 괄호"이면서 stack이 비어있을 경우 flag = false로 변경 후 반복문 종료
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }
                    // stack에 값이 존재하는 경우 stack의 가장 위쪽에 저장된 "열린 괄호"와 x의 "닫힌 괄호"가 한 짝이면 stack.pop() 그렇지 않으면 flag = false로 변경 후 반복문 탈출
                    char t = stack.peek();
                    if((t == '(' && x ==')') || (t=='{' && x == '}') || (t=='[' && x ==']'))stack.pop();
                    else{
                        flag = false;
                        break;
                    }
                }
            }
            // flag의 필요성은 만약 s가 닫는 괄호부터 시작한 경우 break를 통해 stack.isEmpty() = true로 의도치 않은 카운팅을 막기위해
            if(flag && stack.isEmpty())cnt++;

            int j;
            for(j=0; j<n-1; j++){
                arr[j] = arr[j+1];
            }
            arr[j] = tmp;
        }
        return cnt;
    }
}
