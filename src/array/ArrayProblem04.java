package array;

import java.util.*;
import java.util.Map.*;

import static java.lang.Double.compare;

public class ArrayProblem04 {
    public static void main(String[] args){
        int[] arr = {2,1,2,6,2,4,3,3};
        System.out.println(Arrays.toString(s6(5, arr)));
        }

    public static int[] s6(int n, int[] stages){
        // 각 스테이지의 진행중인 사용자의 수를 담는 배열의 인덱스 번호가 곧, 스테이지 번호를 나타내기 위해 배열의 크기를 0 ~ N+1까지의 크기인 [n+2]의 크기로 지정
        int[] arr = new int[n+2];
        for(int x : stages)arr[x]++;

        // Key를 인덱스 번호 Value를 실패율로 가지는 HashMap 생성
        Map<Integer, Double> failsRatios = new HashMap<>();

        // 총 사용자 수 / 실패율 계산에서 사용
        int total = stages.length;

        // failsRatio에 스테이지번호 + 실패율을 각각 Key와 Value로 하여 값 지정
        for(int i = 1 ; i <= n ; i++){
           if(arr[i] == 0){
               failsRatios.put(i, 0.);
           }
           else{
               failsRatios.put(i, arr[i]/(double)total);
           }
           total -= arr[i];
        }

        // Map.Entry<K,V> : Map 안에 들어있는 "키-값 한 쌍(1개)"을 하나의 객체로 표현한 타입
        // entrySet() : Map의 Entry를 Set 타입으로 반환 failsRatio.entrySet() = Set<Map.Entry<Integer, Double>> => Entry가 여러 개 모인 Set 타입
        // .mapToInt(Map.Entry::getKey) : 정렬 종료 후에도 Stream은 Entry이므로 .mapToInt(Map.Entry::getKey)를 통해 결과를 IntStream 으로 변경
        int[] result = new int[n];
        return failsRatios.entrySet().stream().sorted((o1, o2) -> {
            int cmp = Double.compare(o2.getValue(), o1.getValue());
            if(cmp != 0)return cmp;
            return Integer.compare(o1.getKey(), o2.getKey());
        }).mapToInt(HashMap.Entry::getKey).toArray();

    }
}



