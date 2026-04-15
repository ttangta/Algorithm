import java.util.*;
import java.util.stream.*;
class Solution {
    private static final int[][] pattern = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
    public int[] solution(int[] answers) {
        int[] score = new int[pattern.length];
        for(int i=0; i<answers.length; i++){
            int answer = answers[i];
            for(int j=0; j<pattern.length; j++){
                int studentAnaswer = pattern[j][i % (pattern[j].length)];
                if(answer == studentAnaswer)score[j]++;
            }
        }
        int max = Arrays.stream(score).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<score.length; i++){
            if(max == score[i])answer.add(i+1);
        }
        
        return answer.stream().sorted(Comparator.naturalOrder()).mapToInt(Integer::intValue).toArray();
    }
}