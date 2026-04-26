import java.util.*;
class Solution {
    private static HashMap<String, Integer> roman;
    private static void mkRoman(){
        roman = new HashMap<>();
        roman.put("M", 1000);
        roman.put("CM", 900);
        roman.put("D", 500);
        roman.put("CD", 400);
        roman.put("C", 100);
        roman.put("XC", 90);
        roman.put("L", 50);
        roman.put("XL", 40);
        roman.put("X", 10);
        roman.put("IX", 9);
        roman.put("V", 5);
        roman.put("IV", 4);
        roman.put("I", 1);
    }
    public int romanToInt(String s) {
        mkRoman();
        int answer = 0;

        int i;
        for(i = 0; i<s.length()-1; i++){
            int value = 0;
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            if(c1 == 'I' || c1 == 'X' || c1 =='C'){
                String key = String.valueOf(c1).concat(String.valueOf(c2));
                if(roman.containsKey(key)){
                    value = roman.get(key);
                    i++;
                }else value = roman.get(String.valueOf(c1));
            }
            else value = roman.get(String.valueOf(c1));
            answer += value;
        }
        if(i == s.length()-1)answer += roman.get(String.valueOf(s.charAt(i)));
        return answer;
    }
}