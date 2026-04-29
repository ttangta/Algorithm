import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        // two pointer을 nums 배열 정렬
        Arrays.sort(nums);

        // 두 개의 고정 부분 지정
        for(int p1=0; p1<nums.length-3; p1++){
            if(p1 > 0 && nums[p1] == nums[p1-1])continue;
            for(int p2 = p1+1; p2<nums.length; p2++){
                if(p2 > p1+1 && nums[p2] == nums[p2-1])continue;
                int left = p2 +1;
                int right = nums.length-1;
                while(left < right){
                    long sum = (long)nums[p1] + nums[p2] + nums[left] + nums[right];
                    if(sum == target){
                        answer.add(new ArrayList<>(Arrays.asList(nums[p1], nums[p2], nums[left], nums[right])));

                        // 고정된 두 지점과 two pointer 위치의 지점의 합이 target과 같다면 left, right 모두 이동
                        left++;
                        right--;

                        // 포인터가 이동 된 후 두 지점의 값이 이동 전의 값과 같다면 중복 발생 가능성 존재로 해당 지점 건너뛰기
                        while(left < right && nums[left] == nums[left-1])left++;
                        while(left < right && nums[right] == nums[right+1])right--;
                    }
                    else if(sum < target)left++;
                    else right--;
                }
            }
        }
        return answer;
    }
}