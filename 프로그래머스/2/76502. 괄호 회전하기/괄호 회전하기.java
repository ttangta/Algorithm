import java.util.*;
class Solution {
    public int solution(String s) {
        
        int answer = 0;

        for(int i=0; i<s.length(); i++){
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            char[] arr = s.toCharArray();
            char tmp = arr[0];
            // 닫는 괄호 부터 시작 시 괄호가 아닐 수 밖에 없음
            if(s.startsWith(")") || s.startsWith("]") || s.startsWith("}")){
                for(int j=0; j<(s.length()-1); j++){
                    arr[j] = arr[j+1];
                }
                arr[(s.length()-1)] = tmp;
                s = String.valueOf(arr);
                continue;
            }

            for(char c : arr){
                if(c == '(' || c == '[' || c =='{'){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }else{
                        if((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c =='}') || (stack.peek() == '[' && c ==']'))stack.pop();
                    }
                }
            }
            if(stack.isEmpty() && flag)answer++;
            for(int j=0; j<(s.length()-1); j++){
                arr[j] = arr[j+1];
            }
            arr[(s.length()-1)] = tmp;
            s = String.valueOf(arr);
        }


        return answer;
    
    }
} 