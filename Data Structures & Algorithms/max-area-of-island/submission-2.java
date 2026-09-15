class Solution {

    public int ansfunction(int[][] grid,int row,int col){

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) 
        {
             return 0; 
        }
        //marking it visited
        grid[row][col] = 0;


        int area = 1;
        area+=ansfunction(grid,row+1,col);
        
        area+=ansfunction(grid,row-1,col);
        
        area+=ansfunction(grid,row,col+1);
        area+=ansfunction(grid,row,col-1) ;

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea, ansfunction(grid, i, j));
                }

            }
        }
        return maxArea;
    }
}
