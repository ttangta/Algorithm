import java.util.*;
class Solution {
    public int[] solution(int n, int[] stages) {
        int[] status = new int[n+2];
        for(int x : stages ){
            status[x]++;
        }
        int total = stages.length;

        HashMap<Integer, Double> failRatio = new HashMap<>();
        for(int i=1; i<=n; i++){
            int player = status[i];
            if(player == 0){
                failRatio.put(i, 0.);
                continue;
            }
            failRatio.put(i, (double)player/total);
            total -= player;
        }

        Comparator<HashMap.Entry<Integer, Double>> comp = (o1, o2) -> {
            int result = Double.compare(o2.getValue(), o1.getValue());
            if(result != 0)return result;
            return Integer.compare(o1.getKey(), o2.getKey());
        };

        return failRatio.entrySet().stream().sorted(comp).mapToInt(HashMap.Entry::getKey).toArray();
    }
}