import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            // 스택이 비어있는 상황에서 닫는 괄호인경우 그 즉시, false 리턴
            if(stack.isEmpty() && (c==')' || c == '}' || c == ']'))return false;

            // 여는 괄호인 경우
            if(c == '(' || c == '{' || c == '[')stack.push(c);
            // 닫는 괄호인 경우
            else{
                char com = stack.pop();
                switch (com){
                    case '(':
                        if(c == '}' || c == ']')return false;
                        break;
                    case '{':
                        if(c == ')' || c == ']')return false;
                        break;
                    case '[':
                        if(c == ')' || c == '}')return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}