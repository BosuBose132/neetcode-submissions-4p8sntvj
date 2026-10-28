class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length == 0) return 0;

        int rows= grid.length;
        int cols=grid[0].length;
        int islands=0;
        int [][]directions= {{0,1},{1,0},{0,-1},{-1,0}};

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c] == '1'){
                    islands++;
                    bfs(grid, r, c, directions);
                }
            }
        }
        return islands;

    }
    private void bfs(char[][] grid, int r, int c, int[][] directions){
        int row= grid.length;
        int col= grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{r,c});
        grid[r][c] = '0';
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int rows=cur[0];
            int cols=cur[1];

            for(int[] dir: directions){
                int newRow= rows+dir[0];
                int newCol= cols+dir[1];
                if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == '1'){
                    q.offer(new int[]{newRow,newCol});
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }
}
