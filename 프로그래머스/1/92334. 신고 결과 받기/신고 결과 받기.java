import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 각 id가 받은 경고 횟수 HashMap
        LinkedHashMap<String, Integer> totalWarnings = new LinkedHashMap<>();
        for(String s : id_list){
            totalWarnings.put(s, 0);
        }

        // 신고자-대상자 이력을 저장하는 HashMap 객체 생성 (신고이력이 없어도 아이디로 키는 존재해야함)
        HashMap<String, HashSet<String>> reportHistory = new HashMap<>();
        for(String s : id_list)reportHistory.put(s, new HashSet<>());
        for(String s : report){
            String[] arr = s.split(" ");
            String from = arr[0];
            String by = arr[1];
            reportHistory.get(from).add(by);
        }

        // reportHistory의 값을 totalWarnings의 키로 사용하여 해당 키의 값 1증가
        for(String s : id_list){
            HashSet<String> set = reportHistory.get(s);
            for(String x : set){
                totalWarnings.put(x, totalWarnings.get(x) + 1);
            }
        }

        // k이상 누적 경고를 받은 사용자
        ArrayList<String> limitUser = totalWarnings.entrySet().stream().filter(entry -> entry.getValue() >= k).map(Map.Entry::getKey).collect(Collectors.toCollection(ArrayList::new));

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for(String s : id_list)result.put(s, 0);

        for(String s : id_list){
            int cnt = 0;
            for(int i=0; i<limitUser.size(); i++){
                if(reportHistory.get(s).contains(limitUser.get(i)))cnt++;
            }
            result.put(s, cnt);
        }

        return result.entrySet().stream().map(Map.Entry::getValue).mapToInt(Integer::intValue).toArray();
    }
}