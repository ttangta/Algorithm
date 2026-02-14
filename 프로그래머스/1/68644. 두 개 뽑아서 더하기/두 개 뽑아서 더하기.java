import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<numbers.length; j++){
                if(i == j)continue;
                answer.add(numbers[i] + numbers[j]);
            }
        }
        return answer.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
    }
}