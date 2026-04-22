class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        long answer = 0;

        // 1. 공백 문자는 무시 -> 시작지점의 변경
        while(i < s.length() && s.charAt(i) == ' ')i++;

        // 2. 부호 문자 확인
        if(i<s.length() && (s.charAt(i)=='-' || s.charAt(i)=='+')){
            sign = s.charAt(i) == '-'?-1:1;
            i++;
        }

        // 3. 숫자 문자 하나씩 조립
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            answer = answer * 10 + (s.charAt(i) - '0');

            if(answer * sign > Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(answer * sign < Integer.MIN_VALUE)return Integer.MIN_VALUE;
            i++;
        }
        return (int)(answer * sign);
    
        
    }
}