import java.util.*;
class Solution {
    private static List<String> answer;
    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        backTrack(0, 0, n, new StringBuilder());
        return answer;
    }
    private static void backTrack(int open, int close, int n, StringBuilder sb){
        if(sb.length() == n*2){
            answer.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            backTrack(open+1, close, n, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open){
            sb.append(')');
            backTrack(open, close+1, n, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}