class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //https://www.youtube.com/watch?v=T8rD7XbUCLI

        double ans = 0;
        int m = nums1.length;
        int n = nums2.length;
        int leftSize = (m + n + 1) / 2;
        int right = 0;
        if(m>n)
            return findMedianSortedArrays(nums2, nums1);
        
        int left  = 0;
        right = m;
        while(left<=right)
        {
            int mid = left + (right - left)/2;
            int x = leftSize - mid;
            int left1  = (mid == 0) ? Integer.MIN_VALUE : nums1[mid - 1];
            int right1 = (mid == m) ? Integer.MAX_VALUE : nums1[mid];

            int left2  = (x == 0) ? Integer.MIN_VALUE : nums2[x - 1];
            int right2 = (x == n) ? Integer.MAX_VALUE : nums2[x];
            if(left1<=right2 && left2<=right1)
            {
                if((m+n)%2 == 0)
                    return (Math.max(left1,left2) + Math.min(right1,right2))/2.0;
                
                else
                    return Math.max(left1,left2);
            }
            else if(left1 > right2)
                right = mid-1;
            else
                left = mid+1;

        }

        return 0;
        
    }
}