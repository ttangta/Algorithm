import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int cnt = s.length();
        for(int i=0; i<cnt; i++){
            char c1 = s.charAt(i);
            if(c1 == '(' || c1 == '{' || c1 == '[')stack.push(c1);
            else{
                if(stack.isEmpty())return false;
                char c2 = stack.pop();
                if(c2 == '(' && (c1 == '}' || c1 == ']'))return false;
                else if(c2 == '{' && (c1 == ')' || c1 == ']'))return false;
                else if(c2 == '[' && (c1 == ')' || c1 == '}'))return false;
            }
        }

        return stack.isEmpty();
    }
}