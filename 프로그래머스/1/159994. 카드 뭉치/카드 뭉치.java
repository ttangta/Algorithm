import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> c1 = new ArrayDeque<>();
        Queue<String> c2 = new ArrayDeque<>();
        
        for(String x : cards1)c1.offer(x);
        for(String x : cards2)c2.offer(x);
        
        String[] choice = new String[]{c1.poll(), c2.poll()};
        
        for(int i=0; i<goal.length; i++){
            String target = goal[i];
            if(target.equals(choice[0])){
                choice[0] = c1.poll();
            }
            else if(target.equals(choice[1])){
                choice[1] = c2.poll();
            }
            else return "No";
        }
        
        return "Yes";
    }
}