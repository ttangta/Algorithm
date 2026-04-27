import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        for(int p1 = 0; p1 < nums.length-2; p1++){
            if(p1 > 0 && nums[p1] == nums[p1-1])continue;
            int p2 = p1 + 1;
            int p3 = nums.length-1;
            
            while(p2 < p3){
                int sum = nums[p1] + nums[p2] + nums[p3];
                // 현재 3개의 인덱스에 해당하는 값들의 합이 0이면 정답에 추가
                if(sum == 0){
                    answer.add(new ArrayList<>(List.of(nums[p1], nums[p2], nums[p3])));

                    // 중복 결과 건너뛰기 위한 로직
                    // 현재 넣었던 p2의 인덱스 값과 이후 비교할 p2의 인덱스 값이 같다면 1증가 (다음번 p2번째 값 비교 건너뛰기)
                    while(p2 < p3 && nums[p2] == nums[p2+1])p2++;
                    // 현재 넣었던 p3의 인덱스 값이 이후 비교할 p3의 인덱스 값이 같다면 1감소 (다음번 p3번째 값 비교 건너뛰기)
                    while(p2 < p3 && nums[p3] == nums[p3-1])p3--;
                    p2++;
                    p3--;
                }
                // 세 개의 인덱스 값의 합이 0 보다 작다면 two pointer 범위에서 큰 값을 추가해야함 -> p2 증가
                else if(sum < 0)p2++;
                // 세 개의 인덱스 값의 합이 0 보다 크다면 two pointer 범위에서 작은 값 추가 -> p3 감소
                else p3--;
            }

        }


        return answer;
    }
}