class Solution {
    public int trap(int[] height) {

        int ans = 0;
        int leftMax = 0;
        int [] rightMax = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int j = height.length-2;j>=0;j--)
            rightMax[j] = Math.max(height[j],rightMax[j+1]);
        
        for(int i=0;i<height.length;i++)
        {
            leftMax = Math.max(leftMax,height[i]);
            System.out.println(leftMax);
            ans += Math.min(leftMax,rightMax[i]) - height[i];
        }

        return ans;

    }
}
