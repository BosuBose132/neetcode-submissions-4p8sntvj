class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right=nums.length-1;
        while(left<=right){
        int med= left+((right-left)/2);
        if(nums[med]<target){
            left=med+1;
        }else if(nums[med]>target){
            right=med-1;
        }else{
            return med;
        } 
    }
    return -1;
    }
    
}
