import java.util.*;
class Solution {
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;
    public String[] solution(String[] orders, int[] course) { 
        // 해시맵 초기화
        courseMap = new HashMap<>();
        for(int i : course){
            courseMap.put(i, new HashMap<>());
        }

        // 1. 코스를 배열로 만들고 오름차순 정렬해서 가능한 모든 메뉴 구성을 구함
        for(String order : orders){
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }

        ArrayList<String> answer = new ArrayList<>();

        // 모든 코스 후보에 대해서
        for(HashMap<String, Integer> count : courseMap.values()){
            count.values()
                    .stream()
                    .max(Comparator.comparingInt(o -> o))   // 가장 빈도수가 높은 코스를 찾음
                    .ifPresent(cnt -> count.entrySet()      // 코스에 대한 메뉴 수가 가능할 때만
                            .stream()
                            .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1)
                            // 코스 메뉴만 answer 리스트에 추가
                            .forEach(entry -> answer.add(entry.getKey())));
        }
        // 오름차순으로 정렬
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public static void combinations(int idx, char[] order, String result){
        // 필요한 코스 메뉴의 수와 일치하는 것만 저장
        if(courseMap.containsKey(result.length())){
            HashMap<String, Integer> map = courseMap.get(result.length());
            // 해당 코스의 수를 1증가
            map.put(result, map.getOrDefault(result,0) + 1);
        }

        for(int i=idx; i<order.length; i++){
            combinations(i+1, order, result + order[i]);
        }
    }
}