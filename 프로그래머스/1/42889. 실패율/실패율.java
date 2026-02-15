import java.util.*;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> failRatio = new HashMap<>();
        
        int[] challenger = new int[N+2];
        for(int x : stages)challenger[x]++;
        
        int total = stages.length;
        
        for(int i=1; i<=N; i++){
            if(challenger[i]==0){
                failRatio.put(i, 0.);
                continue;
            }
            failRatio.put(i, (double)challenger[i]/total);
            total -= challenger[i];
        }
        
        int[] answer = failRatio.entrySet().stream().sorted((o1, o2) -> {
            int tmp = Double.compare(o2.getValue(), o1.getValue());
            if(tmp != 0)return tmp;
            return Integer.compare(o1.getKey(), o2.getKey());
        }).mapToInt(Map.Entry::getKey).toArray();
        
        return answer;
    }
}