import java.util.*;
class Solution {
    private static HashMap<Character, char[]> map = new HashMap<>();
    private static void mkMap(){
        map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        mkMap();
        combinations(0, digits,"", answer);

        return answer;
    }
    private static void combinations(int idx, String digits, String current, List<String> answer){
        if(digits.length() == current.length()){
            answer.add(current);
            return;
        }

        char key = digits.charAt(idx);
        char[] values = map.get(key);
        for(int i=0; i<values.length; i++){
            combinations(idx+1, digits, current + values[i], answer);
        }

    }  
}