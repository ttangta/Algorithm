import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] clear = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            clear[i] = (int)Math.ceil((100 - progresses[i])/(double)speeds[i]);
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i : clear)queue.addLast(i);
        
        ArrayList<Integer> answer = new ArrayList<>();
        int max = queue.pollFirst();
        int cnt = 1;
        
        while(!queue.isEmpty()){
            int day = queue.pollFirst();
            if(max >= day){
                cnt++;
            }else{
                answer.add(cnt);
                max = day;
                cnt = 1;
            }
        }
        answer.add(cnt);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}