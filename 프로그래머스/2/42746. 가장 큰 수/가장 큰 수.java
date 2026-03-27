import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for(int number : numbers){
            list.add(String.valueOf(number));
        }
        
        list.sort((o1, o2) -> (o2+o1).compareTo(o1 + o2));
        
        StringBuilder sb = new StringBuilder();
        for(String s : list)sb.append(s);
        return sb.charAt(0) == '0'? "0" : sb.toString();
    }
}