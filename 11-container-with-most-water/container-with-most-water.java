class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, answer = Integer.MIN_VALUE;
        while(left < right){
            int wide = right - left;
            int h1 = height[left];
            int h2 = height[right];
            int h = Math.min(h1, h2);
            answer = Math.max(answer, wide * h);
            if(h2 < h1)right--;
            else left++;
        }

        return answer;
    }
}