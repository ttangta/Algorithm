package array;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayProblem04_NotUseHashMap {
    public static void main(String[] args){
        System.out.println(Arrays.toString(s6_1(5, new int[]{2,1,2,2,6,2,4,3,3})));
    }

    public static int[] s6_1(int n, int[] stages){
        // 각 스테이지 진행중인 사용자 수를 저장하는 배열
        int[] arr = new int[n];
        for(int i = 0 ; i < stages.length ; i++){
            if(stages[i]-1 == n)continue;
            arr[stages[i]-1]++;
        }

        // 총 사용자 수
        int total = stages.length;

        // 실패율을 저장할 배열 생성 : if-else를 안붙혀서 오답 발생
        double[] failsRate = new double[n];
        for(int i = 0 ; i < arr.length ; i++){
            if(total == 0)failsRate[i] = 0.0;
            else {
                failsRate[i] = arr[i] / (double) total;
                total -= arr[i];
            }
        }

        // 1 ~ N번까지의 스테이지 배열 : Comparator 사용을 위하여 레퍼런스 타입으로 배열 생성
        Integer[] order = new Integer[n];
        for(int i = 0 ; i < n ; i++)order[i] = i+1;

        // sort에 매개변수로 사용할 내림차순 및 동일 값은 작은 숫자부터 정렬되도록 비교해주는 Comparator 객체 생성
        Comparator<Integer> stageFailComparator = (a, b) -> {
            int cmp = Double.compare(failsRate[b-1], failsRate[a-1]);
            if(cmp != 0) return cmp;
            return Integer.compare(a, b);
        };

        Arrays.sort(order, stageFailComparator);

        int[] result = Arrays.stream(order).mapToInt(Integer::intValue).toArray();

        return result;
    }
}
