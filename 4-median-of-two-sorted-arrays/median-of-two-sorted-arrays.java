class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // nums1의 배열의 크기가 항상 작도록 지정 -> nums1의 요소 개수를 기준으로 왼쪽애 개수를 계산하려 하고자 할때 음수 방지
        if(nums1.length > nums2.length){
            int[] tmp = nums1.clone();
            nums1 = nums2;
            nums2 = tmp;
        }

        // 각 배열의 크기
        int m = nums1.length;
        int n = nums2.length;

        // nums1의 요소를 왼쪽에 하나도 사용하지 않은 경우(nums1의 사용 요소의 하한)와 모두 사용한 경우(nums12의 사용 요소의 상한)를 나타내는 변수
        int left = 0;
        int right = m;
        while(left <= right){
            // nums1의 요소를 왼쪽에 넣을 수 있는 개수를 최소 사용과 최대 사용의 중간 지점에서 시작
            int partition1 = (left + right)/2;

            // partition1이 지정되면 nums2에서 왼쪽에 넣을 수 있는 요소의 개수 = 왼쪽의 개수(n+m+1)/2 - nums1에서 사용한 요소의 개수
            int partition2 = (m+n+1)/2 - partition1;

            // nums1의 왼쪽의 최대값 : partition1(왼쪽에 넣은 nums1의 요소 개수)가 0 이면 -> nums1의 요소를 왼쪽에 하나도 넣지 않은 경우 이 경우 반드시 nums2의 왼쪽 최대값이 선택되도록 maxLeft1의 값 설정
            int maxLeft1 = (partition1 == 0)?Integer.MIN_VALUE:nums1[partition1-1];

            // nums1의 오른쪽 최솟값 : partition1의 개수가 nums1의 전체 크기이면 -> nums1의 모든 요소를 왼쪽에 담은 상황 이 경우 오른쪽에 nums1의 요소는 아무것도 사용안됨 반드시 nums2의 오른쪽 최솟값이 선택되도록 값 설정
            int minRight1 = (partition1 == m)?Integer.MAX_VALUE:nums1[partition1];

            // nums2의 왼쪽의 최대값 : partition2가 0이면 -> nums2의 요소를 왼쪽에 하나도 넣지 않은 경우 이 경우 반드시 nums1의 왼쪽 최대값이 선택되도록 maxLeft2의 값 설정
            int maxLeft2 = (partition2 == 0)?Integer.MIN_VALUE:nums2[partition2-1];

            // nums2의 오른쪽 최솟값 : partition의 개수가 nums2의 전체 크기이면 -> nums2의 모든 요소를 왼쪽에 담은 상황 이 경우 오른쪽에 nums2의 요소는 아무것도 사용안됨 반드시 nums1의 오른쪽 최솟값이 선택되도록 값 설정
            int minRight2 = (partition2 == n)?Integer.MAX_VALUE:nums2[partition2];

            // 이미 정렬된 두 배열 nums1, nums2의 배열의 합이 제대로 결합된 상태라면 nums1에서 왼쪽에 사용한 최대값의 요소는 nums2에서 오른쪽에 사용된 최소값보다 작거나 같아야 하고, nums2에서 왼쪽에 사용한 최대값의 요소는 nums1에서 오른쪽에 상용된 최솟값보다 작거나 같아야 한다
            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                // 두 배열의 크기의 합이 짝수인경우 -> 중간값 : (왼쪽의 가장 큰 수 + 오른쪽의 가장 작은 수)/2.0
                if((m+n)%2==0)return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                // 홀수인 경우 -> 중간값 : 왼쪽의 가장 큰 수
                else return Math.max(maxLeft1, maxLeft2);
            }
            // nums1의 요소가 왼쪽에 초과 배치된 경우 -> nums1의 왼쪽 요소 개수 줄임 = partition1 수 줄임 = right 감소
            else if(maxLeft1 > minRight2)right = partition1 -1;
            // nums2의 요소가 왼쪽에 초과 배치된 경우 -> nums1의 왼쪽 요소 개수 늘림 = partition1 수 증가 = left 증가
            else left = partition1 + 1;
        }
        return 0.;
    }
}