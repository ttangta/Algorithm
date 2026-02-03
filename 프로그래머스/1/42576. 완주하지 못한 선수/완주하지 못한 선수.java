import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String x : participant)hashMap.put(x, hashMap.getOrDefault(x, 0)+1);

        for(String x : completion){
            hashMap.put(x, hashMap.get(x)-1);
            if(hashMap.get(x)==0)hashMap.remove(x);
        }

        return  hashMap.keySet().iterator().next();

    }
}