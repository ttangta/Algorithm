import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // two pointer을 위한 정렬 처리
        Arrays.sort(nums);

        // 최초 세 요소의 합은 단순 nums의 앞단 3요소의 합
        int answer = nums[0] + nums[1] + nums[2];
        // target 과 최초 세 요소의 합의 차
        int dif = Math.abs(target-answer);

        for(int p1 = 0; p1 < nums.length-2; p1++){
            int p2 = p1+1;
            int p3 = nums.length-1;
            while(p2 < p3){
                int sum = nums[p1] + nums[p2] + nums[p3];
                if(dif > Math.abs(target-sum)){
                    dif = Math.abs(target-sum);
                    answer = sum;
                }
                if(sum < target)p2++;
                else if(sum > target)p3--;
                else return sum;
            }
        }
        return answer;
    }
}