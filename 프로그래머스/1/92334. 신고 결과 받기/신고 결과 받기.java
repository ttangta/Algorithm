import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> status = new HashMap<>();
        HashMap<String, HashSet<String>> history = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        
        for(String s : id_list){
            status.put(s, 0);
            history.put(s, new HashSet<>());
            result.put(s, 0);
        }
        
        for(String s : report){
            String[] arr = s.split(" ");
            String from = arr[0];
            String by = arr[1];
            history.get(from).add(by);
        }
        
        for(String s : id_list){
            HashSet<String> target = history.get(s);
            target.forEach(t -> {
               status.put(t, status.get(t)+1); 
            });
        }
        
        String[] limited = status.entrySet().stream().filter(entry -> entry.getValue()>=k).map(Map.Entry::getKey).collect(Collectors.toCollection(ArrayList::new)).toArray(String[]::new);
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            String key = id_list[i];
            for(String s : limited){
                if(history.get(key).contains(s))result.put(key, result.get(key)+1);
            }
            
            answer[i] = result.get(key);
        }
        
        return answer;  
    } 
}