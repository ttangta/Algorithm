import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<progresses.length; i++){
            int clear = (int)Math.ceil((100 - progresses[i])/(double)speeds[i]);
            queue.addLast(clear);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        int cnt = 1;
        int max = queue.pollFirst();
        
        while(!queue.isEmpty()){
            int day = queue.pollFirst();
            if(max >= day)cnt++;
            else{
                answer.add(cnt);
                max = day;
                cnt = 1;
            }
        }
        answer.add(cnt);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}