import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> info = new HashMap<>();
        
        for(String s : record){
            if(s.startsWith("Enter") || s.startsWith("Change")){
                String[] arr = s.split(" ");
                info.put(arr[1], arr[2]);
            }
        }
        
        ArrayList<String> answer = new ArrayList<>();
        for(String s : record){
            if(s.startsWith("Enter")){
                String[] arr = s.split(" ");
                answer.add(info.get(arr[1]) + "님이 들어왔습니다.");
            }
            else if(s.startsWith("Leave")){
                String[] arr = s.split(" ");
                answer.add(info.get(arr[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(String[]::new);
    }
}