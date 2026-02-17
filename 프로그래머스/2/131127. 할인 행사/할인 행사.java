import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> goal = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            goal.put(want[i], number[i]);
        }
        
        for(int i=0; i<discount.length-9; i++){
            HashMap<String,Integer> result = new HashMap<>();
            for(int j=i; j<=(i+9); j++){
                result.put(discount[j], result.getOrDefault(discount[j],0)+1);
            }
            if(goal.equals(result))answer++;
        }
        
        return answer;
    }
}