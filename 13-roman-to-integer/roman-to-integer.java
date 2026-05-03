class Solution {
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public int romanToInt(String s) {
        int answer = 0;
        int idx = 0;
        for(idx = 0; idx<s.length()-1; idx++){
            char c1 = s.charAt(idx);
            char c2 = s.charAt(idx+1);
            if((c1 == 'C' && (c2 == 'M' || c2 == 'D')) || c1 == 'X' && (c2 == 'C' || c2 == 'L') || c1 == 'I' && (c2 == 'X' || c2 == 'V')){
                String symbol = String.valueOf(c1).concat(String.valueOf(c2));
                for(int j=0; j<symbols.length; j++){
                    if(symbol.equals(symbols[j])){
                        answer += values[j];
                        idx++;
                    }
                }
            }
            else{
                for(int j=0; j<symbols.length; j++){
                    if(String.valueOf(c1).equals(symbols[j]))answer+=values[j];
                }
            }
        }
        if(idx < s.length()){
            for(int i=idx; i<s.length(); i++){
                char c = s.charAt(i);
                for(int j=0; j<symbols.length; j++){
                    if(String.valueOf(c).equals(symbols[j]))answer+=values[j];
                }
            }
        }

        return answer;
    }
}