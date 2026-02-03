import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hashMap = new HashMap<>();

        int n = record.length;

        // 정답 문자열을 담을 문자열 배열
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String cmd = null, uid = null, nickName = null;
            String[] arr = record[i].split(" ");
            cmd = arr[0];
            uid = arr[1];
            if(arr.length == 3)nickName = arr[2];

            if(cmd.equals("Enter") || cmd.equals("Change")){
                hashMap.put(uid, nickName);
            }
        }

        for(int i=0; i<n; i++){
            String[] arr = record[i].split(" ");
            if(arr[0].equals("Enter"))answer.add(hashMap.get(arr[1]) + "님이 들어왔습니다.");
            else if(arr[0].equals("Leave"))answer.add(hashMap.get(arr[1]) + "님이 나갔습니다.");
            else continue;
        }

        return answer.stream().toArray(String[]::new);
    }
}