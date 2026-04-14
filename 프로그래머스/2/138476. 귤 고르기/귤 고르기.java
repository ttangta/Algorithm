import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int maxSize = Arrays.stream(tangerine).max().getAsInt();
        int[] sizes = new int[maxSize+1];
        for(int size : tangerine)sizes[size] += 1;
        sizes = Arrays.stream(sizes).boxed().sorted((o1, o2) -> Integer.compare(o2, o1)).mapToInt(Integer::intValue).toArray();
        int answer = 1;
        for(int i=0; i<sizes.length; i++){
            int cnt = sizes[i];
            if(k-cnt > 0){
                answer++;
                k -= cnt;
            }else break;
        }
        return answer;
    }  
}