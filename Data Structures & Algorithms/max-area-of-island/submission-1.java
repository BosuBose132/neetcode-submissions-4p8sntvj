class Solution {
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
     int rows= grid.length;
     int cols=grid[0].length;
     
     int maxArea=0;
     for(int r=0;r<rows;r++){
        for(int c=0;c<cols;c++){
            if(grid[r][c]==1){
                maxArea= Math.max(maxArea,bfs(grid,r,c));
            }
        }
     }
    return maxArea;
    }
    private int bfs(int[][] grid,int rows,int cols){    
        int area=1;
        int row= grid.length;
        int col=grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        grid[rows][cols]=0;
        q.add(new int[]{rows,cols});
        while(!q.isEmpty()){
            int[] cur= q.poll();
            int r= cur[0];
            int c= cur[1];
             for(int[] dir: directions){
                int newRow= dir[0]+r;
                int newCol= dir[1]+c;
                if(newRow>=0 && newRow<row && newCol>=0 && newCol<col && grid[newRow][newCol]==1){
                    area++;
                    q.add(new int[]{newRow,newCol});
                    grid[newRow][newCol]=0;
                }
             }
        }
        return area;
    }
}
