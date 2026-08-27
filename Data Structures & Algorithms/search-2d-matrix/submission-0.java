class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows= matrix.length;
        int cols= matrix[0].length;
        int left=0, right= rows*cols-1;
        while(left<=right){
            int mid= left+(right-left)/2;
            int row= mid/cols, col= mid%cols;
            int value=matrix[row][col];
            if(value>target){
                right=mid-1;
            }else if(value<target){
                left=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}
