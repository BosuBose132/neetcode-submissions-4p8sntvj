class Solution {
    public int searchInsert(int[] nums, int target) {
        int res=nums.length;
        int l=0, r=nums.length-1;
        while(l<=r){
            int mid= l+(r-l)/2;
            if(nums[mid]>target){
                res=mid;
                r=mid-1;
            }else if(nums[mid]==target){
                return mid;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
}