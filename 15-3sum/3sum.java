import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        // 1. 투 포인터 사용을 위한 nums 배열 정렬 처리
        Arrays.sort(nums);

        // 2. nums[i] 요소를 고정 시킴 : 이후 최소 left, right 포인터 두개가 필요하니 외부 반복문의 반복 범위 조정
        for(int i=0; i<nums.length-2; i++){
            int point = nums[i];
            // 고정된 요소의 값이 이전의 값과 동일하면 해당 요소에 대한 반복은 건너뜀
            if(i > 0 && nums[i] == nums[i-1])continue;
            int left = i+1, right = nums.length-1;
            while(left < right){
                // 각 위치의 3요소의 합을 구함
                int sum = point + nums[left] + nums[right];
                // 세 요소의 합이 0보다 작으면 left위치를 이동 시켜 3개의 요소의 합의 값 증가 시킴
                if(sum < 0){
                    left++;
                }
                // 세 요소의 합이 0보다 작으면 right위치를 이동 시켜 3개의 요소의 합의 값 감소 시킴
                else if(sum > 0){
                    right--;
                }
                // 새 요소의 합이 0과 같으면 -> 해당 요소들을 정답에 추가 시킨 후 모든 포인터 이동
                else{
                    answer.add(new ArrayList<>(List.of(point, nums[left], nums[right])));
                    left++;
                    right--;

                    // 만약 이동된 각 포인터의 값이 이전과 같다면 이동된 값이 이전과 다를때까지 포인터 이동
                    while(left < right && nums[left] == nums[left-1])left++;
                    while(left < right && nums[right] == nums[right+1])right--;
                }
            }
        }
        return answer;
    }
}