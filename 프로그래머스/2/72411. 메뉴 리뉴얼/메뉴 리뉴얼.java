import java.util.*;

class Solution {
    private static HashMap<Integer, HashMap<String, Integer>> courseMenu;
    public String[] solution(String[] orders, int[] course) {
        courseMenu = new HashMap<>();
        for(int x : course)courseMenu.put(x, new HashMap<>());
        
        for(String s : orders){
            char[] orderArray = s.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }
        
        ArrayList<String> answer = new ArrayList<>();
        for(HashMap<String, Integer> innerMap : courseMenu.values()){
            innerMap.values().stream().max(Comparator.comparingInt(o -> o)).ifPresent(cnt -> innerMap.entrySet().stream().filter(entry -> cnt.equals(entry.getValue()) && cnt>1).forEach(entry -> answer.add(entry.getKey())));
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    private static void combinations(int idx, char[] order, String result){
        if(courseMenu.containsKey(result.length())){
            HashMap<String, Integer> map = courseMenu.get(result.length());
            map.put(result, map.getOrDefault(result, 0)+1);
        }
        
        for(int i=idx; i<order.length; i++){
            combinations(i+1, order, result+order[i]);
        }
    }
}