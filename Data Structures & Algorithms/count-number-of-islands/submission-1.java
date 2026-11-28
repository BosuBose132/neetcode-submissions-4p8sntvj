class Solution {
    int [][] dir={{0,-1},{1,0},{0,1},{-1,0}};
    
    public int numIslands(char[][] grid) {
        int n=grid.length;
    int m=grid[0].length;
        int land=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            if(grid[i][j]=='1'){
                land++;
                bfs(grid,i,j,dir);
            }
            }
        }
        return land;
    }
    private void bfs(char[][]grid,int r,int c,int[][]dir){
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{r,c});
        grid[r][c]='0';
        while(!q.isEmpty()){
            int[] cur= q.poll();
            int row=cur[0];
            int col=cur[1];
            for(int[] dirs:dir){
                int rows=row+dirs[0];
                int cols=col+dirs[1];
                if(rows>=0 && rows<n && cols>=0 && cols<m && grid[rows][cols]=='1'){
                    q.offer(new int[]{rows,cols});
                    grid[rows][cols]='0';
                }
            }
        }
    } 
}
