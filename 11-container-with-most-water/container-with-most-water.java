class Solution {
    public int maxArea(int[] height) {
        int answer = Integer.MIN_VALUE;
        int left = 0, right = height.length-1;
        while(left < right){
            answer = Math.max(answer, (right-left) * Math.min(height[left], height[right]));

            if(height[left] < height[right])left++;
            else if(height[left] > height[right])right--;
            else{
                left++;
                right--;
            }
        }

        return answer;
    }
}