class Solution {
    public void nextPermutation(int[] nums) {
        int pivotIdx = -1;
        for(int i=nums.length-1; i>=1; i--){
            if(nums[i-1] < nums[i]){
                pivotIdx = i-1;
                break;
            }
        }
        if(pivotIdx == -1){
            reverse(0, nums.length-1, nums);
            return;
        }
        
        int changeIdx = -1;
        for(int i=nums.length-1; i > pivotIdx; i--){
            if(nums[pivotIdx] < nums[i]){
                changeIdx = i;
                break;
            }
        }
        swap(pivotIdx, changeIdx, nums);
        reverse(pivotIdx+1, nums.length-1, nums);
    }
    private static void reverse(int left, int right, int[] nums){
        while(left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
    private static void swap(int pivotIdx, int changeIdx, int[] nums){
        int tmp = nums[pivotIdx];
        nums[pivotIdx] = nums[changeIdx];
        nums[changeIdx] = tmp;
    }
}