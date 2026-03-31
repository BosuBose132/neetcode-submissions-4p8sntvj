class Solution {
    public int maxArea(int[] heights) {
        int left= 0, right= heights.length-1;
        int area;
        int max=0;
        while(left<right){
            int width= right-left;
            area= Math.min(heights[left],heights[right])*width;
            if(area>max){
                max=area;
            }
            if(heights[left]<heights[right]){
            left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
