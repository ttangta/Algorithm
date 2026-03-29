import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : topping)map.put(x, map.getOrDefault(x, 0)+1);
        
        HashSet<Integer> set = new HashSet<>();
        for(int x : topping){
            set.add(x);
            map.put(x, map.get(x)-1);
            
            if(map.get(x) == 0)map.remove(x);
            
            if(set.size() == map.size())answer++;
        }
        
        
        return answer;
    }
}