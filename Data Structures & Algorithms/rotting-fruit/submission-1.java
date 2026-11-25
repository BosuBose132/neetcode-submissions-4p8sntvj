class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m =grid[0].length;
        Queue<int[]> q= new ArrayDeque<>();
        int[][] vis= new int[n][m];
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
                if(grid[i][j]== 1){
                    fresh++;
                }
            }
        }
        int minutes=0;
        int[][]dir= {{-1,0},{0,1},{1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row=cur[0];
            int col=cur[1];
            int time=cur[2];
            for(int[] dirs: dir){
                int nr= row+dirs[0];
                int nc= col+dirs[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(new int[]{nr,nc,time+1});
                    minutes=Math.max(minutes,time+1);
                }
            }
        }
        if(fresh==0){
            return minutes;
        }else{
            return -1;
        }
    }
}
