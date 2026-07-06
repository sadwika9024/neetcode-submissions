class Solution {
    public int maxArea(int[] heights) {
        int i =0;
        int j = heights.length-1;
        int area = 0;
        int maxArea = 0;
        while(i < j)
        {
            area = Math.min(heights[i],heights[j])*(j-i);

            maxArea = Math.max(maxArea,area);
            if(heights[i]<heights[j])
                i++;
            else
                j--;
        }
        
        return maxArea;
    }
}
