import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> queue1 = new ArrayDeque<>();
        ArrayDeque<String> queue2 = new ArrayDeque<>();
        
        for(String s : cards1)queue1.addLast(s);
        for(String s : cards2)queue2.addLast(s);
        
        String s1 = queue1.pollFirst();
        String s2 = queue2.pollFirst();
        
        for(int i=0; i<goal.length; i++){
            String s = goal[i];
            if(s.equals(s1) && !queue1.isEmpty())s1 = queue1.pollFirst();
            else if(s.equals(s2) && !queue2.isEmpty())s2 = queue2.pollFirst();
            else if(!s.equals(s1) && !s.equals(s2)) return "No";
        }
        
        
        return "Yes";
    }
}