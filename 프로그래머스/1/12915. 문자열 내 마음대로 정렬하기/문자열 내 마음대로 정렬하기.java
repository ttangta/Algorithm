import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if(a.charAt(n) == b.charAt(n))return a.compareTo(b);
            else return Integer.compare(a.charAt(n), b.charAt(n));
        });
            
        for(String s : strings){
            pq.offer(s);
        }
        
        String[] answer = new String[strings.length];
        for(int i=0; i<strings.length; i++)answer[i] = pq.poll();
        return answer;
    }
}