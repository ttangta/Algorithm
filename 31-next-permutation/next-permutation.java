class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int pivotIdx = -1;
        for(int i=n-1; i>=1; i--){
            if(nums[i-1] < nums[i]){
                pivotIdx = i-1;
                break;
            }
        }

        if(pivotIdx == -1){
            reverse(nums, 0, n-1);
            return;
        }

        int changeIdx = -1;
        for(int i=n-1; i>pivotIdx; i--){
            if(nums[i] > nums[pivotIdx]){
                changeIdx = i;
                break;
            }
        }

        swap(nums, pivotIdx, changeIdx);

        reverse(nums, pivotIdx + 1, n -1);
    }
    private static void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}