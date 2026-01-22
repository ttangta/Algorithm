package array;

import java.util.ArrayList;
import java.util.Arrays;

// 프로그래머스 : 모의고사
public class ArrayProblem02 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(s4(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(s4(new int[]{1,3,2,4,2})));
    }

    public static int[] s4(int[] answers){
        // 학생들의 패턴을 고정해둔 2차원 배열
        int[][] pattern = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };

        // 각 학생들이 정답 개수를 저장할 배열 생성
        int[] scores = new int[pattern.length];

        // 1. 해당 메서드 호출 시 전달 받은 총 답만큼 반복
        for(int i = 0 ; i < answers.length ; i++){
            // 2. 학생의 총 인원 만큼 반복하면 내부에서 각 학생의 i번째 문제에 대한 답과 비교
            for(int j = 0 ; j < pattern.length ; j++){
                if(answers[i] == pattern[j][i % pattern[j].length])scores[j]++;
            }
        }

        // scores 중에서 가장 많은 수를 값으로 변수 선언
        int max = Arrays.stream(scores).max().getAsInt();

        // scores의 각 인덱스 값을 비교하여 max와 동일하면 해당 인덱스+1의 값을 ArrayList에 저장
        // 인덱스 + 1 의 이유는 인덱스는 0부터 시작 즉, 0이 1번 학생이기 때문
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < scores.length ; i++){
            if(scores[i] == max)result.add(i+1);
        }

        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
