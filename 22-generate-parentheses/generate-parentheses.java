class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backTrack(0, 0, new StringBuilder(), n, answer);
        return answer;
    }
    private static void backTrack(int open, int close, StringBuilder sb, int n, List<String> answer){
        if(sb.length() == n*2){
            answer.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            backTrack(open+1, close, sb, n, answer);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(')');
            backTrack(open, close+1, sb, n, answer);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}