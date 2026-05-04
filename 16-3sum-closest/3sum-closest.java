import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int close = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;

        // 투 포인터 사용을 위한 nums 배열 정렬
        Arrays.sort(nums);

        // 세 개의 요소의 합을 구해야 하므로 이동을 하는 두 개의 포인터 외의 하나의 고정된 값 지정
        for(int i=0; i<nums.length-2; i++){
            int point = nums[i];
            int left = i+1, right = nums.length-1;
            while(left < right){
                int sum = point + nums[left] + nums[right];
                // 현재 계산된 합과 target의 차와 기존 근사값의 차를 비교하여 현재 sum에 대한 근사값이 더 작으면 갱신
                if(close > Math.abs(sum-target)){
                    close = Math.abs(sum-target);
                    answer = sum;
                }
                // 만약 현재 sum의 값이 target 보다 작으면 작은 값을 가리키는 left 포인트를 이동 시켜 값을 증가 시킴
                if(sum < target)left++;
                // 만약 현재 sum의 값이 target 보다 크면 큰 값을 가리키는 right 포인트를 이동 시켜 값을 증가 시킴
                else if(sum > target)right--;
                // 만약 현재 sum의 값이 target과 정확히 일치하면 현재 sum 그 자체로 답이기 때문에 sum 그래도 반환
                else return sum;
            }
        }
        return answer;
    }
}