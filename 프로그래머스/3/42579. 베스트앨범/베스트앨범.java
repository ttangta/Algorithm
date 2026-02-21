import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, ArrayList<int[]>> detail = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
            if(!detail.containsKey(genres[i]))detail.put(genres[i], new ArrayList<>());
            detail.get(genres[i]).add(new int[]{i, plays[i]});
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        Stream<String> gStream = total.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())).map(Map.Entry::getKey);
        
        gStream.forEach(g -> {
            Stream<int[]> sStream = detail.get(g).stream().sorted((o1, o2) -> Integer.compare(o2[1], o1[1])).limit(2);
            sStream.forEach(s -> answer.add(s[0]));
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}