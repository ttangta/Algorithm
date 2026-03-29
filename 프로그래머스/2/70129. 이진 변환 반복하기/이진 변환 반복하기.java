class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int removeZero = 0;
        
        while(s.length() > 1){
            cnt++;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0')removeZero++;
            }
            
            int len = s.replace("0", "").length();
            s = Integer.toBinaryString(len);
        }
        
        answer[0] = cnt;
        answer[1] = removeZero;
        return answer;
    }
}