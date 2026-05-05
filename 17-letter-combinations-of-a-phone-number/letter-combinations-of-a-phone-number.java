class Solution {
    private static final String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private static List<String> answer;
    public List<String> letterCombinations(String digits) {
        answer = new ArrayList<>();
        combinations(0, digits, new StringBuilder());
        return answer;
    }
    private static void combinations(int idx, String digits, StringBuilder sb){
        if(sb.length() == digits.length()){
            answer.add(sb.toString());
            return;
        }
        int pn = Integer.parseInt(String.valueOf(digits.charAt(idx)));
        for(int i=0; i<str[pn].length(); i++){
            sb.append(str[pn].charAt(i));
            combinations(idx+1, digits, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}