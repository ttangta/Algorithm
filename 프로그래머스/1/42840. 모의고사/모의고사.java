import java.util.*;
class Solution {
    private static int[][] pattern = {
        {1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}
    };
    public int[] solution(int[] answers) {
        int[] scores = new int[pattern.length];
        
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<scores.length; j++){
                if(answers[i] == pattern[j][i%pattern[j].length])scores[j]++;
            }
        }
        
        int max = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<scores.length; i++){
            if(scores[i] == max)answer.add(i+1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}