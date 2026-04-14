import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lidx = 0, ridx = people.length-1;
        while(lidx < ridx){
            int f = people[lidx];
            int b = people[ridx];
            int total = f + b;
            if(total <= limit){
                answer++;
                lidx++;
                ridx--;
            }else{
                answer++;
                ridx--;
            }
        }
        if(lidx == ridx)answer+=1;
        return answer;
    }
}