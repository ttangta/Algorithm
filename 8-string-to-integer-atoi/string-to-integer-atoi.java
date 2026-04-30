class Solution {
    public int myAtoi(String s) {
        // 문자열 s의 양끝 공백 지우기
        s = s.trim();
        if(s.isEmpty())return 0;
        int i = 0;
        int signe = 1;
        int answer = 0;

        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            signe = s.charAt(i) == '-'?-1:1;
            i++;
        }

        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int n = s.charAt(i) - '0';

            if((answer > Integer.MAX_VALUE/10 || (answer == Integer.MAX_VALUE/10 && n > 7))
                || (answer < Integer.MIN_VALUE/10 || (answer == Integer.MIN_VALUE/10 && n > 8))){
                return signe==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }

            answer = answer * 10 + n;

            i++;
        }


        return answer * signe;
    }
}