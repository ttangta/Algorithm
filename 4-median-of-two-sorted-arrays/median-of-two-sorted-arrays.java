import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        for(int i=0; i<nums1.length; i++)arr[i] = nums1[i];
        for(int i=0; i<nums2.length; i++)arr[nums1.length + i] = nums2[i];
        Arrays.sort(arr);
        int count = arr.length%2==0?2:1;
        int mid = arr.length/2;
        int startIdx = arr.length%2==0?mid-1:mid;
        int sum = 0;
        for(int i=0; i<count; i++)sum+=arr[startIdx + i];
        return (double)sum / count;
    }
}