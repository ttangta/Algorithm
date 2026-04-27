import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        // nums의 배열크기만큼 반복하면서 nums[i] 값을 키 i 즉, 인덱스를 값으로 지정 "nums[i]:i" 형태
        for(int i=0; i<nums.length; i++)map.put(nums[i], i);


        // nums의 각 요소에 접근하면서 taget에서 nums[i]의 요소의 값을 뺀 값 계산 이를 other 이라고 지칭함
        for(int i=0; i<nums.length; i++){
            int other = target - nums[i];
            // 만약 other의 값이 map의 키에 존재한다면 현재 nums[i] 번째 인덱스와 map의 other의 값에 해당하는 nums의 인덱스 값의 합으로 target 값 도출 가능
            // * 자기 자신을 더해서 target에 도달하는 경우를 방지하기 위한 조건 추가
            if(map.containsKey(other) && map.get(other) != i){
                answer[0] = i;
                answer[1] = map.get(other);
                return answer;
            }   
        }
        return null;
    }
}