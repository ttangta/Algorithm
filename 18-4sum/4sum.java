import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            int p1 = nums[i];
            if(i > 0 && nums[i] == nums[i-1])continue;
            for(int j=i+1; j<nums.length-2; j++){
                int p2 = nums[j];
                if(j > i+1 && nums[j] == nums[j-1])continue;
                int left = j+1, right = nums.length-1;
                while(left < right){
                    long sum = (long)p1 + p2 + nums[left] + nums[right];
                    if(sum < target)left++;
                    else if(sum > target)right--;
                    else{
                        answer.add(new ArrayList<>(List.of(p1, p2, nums[left], nums[right])));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1])left++;
                        while(left < right && nums[right] == nums[right+1])right--;
                    }
                }
            }
        }

        return answer;
    }
}