class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l<=r){
            int num= l+(r-l)/2;
            if(nums[num]> target){
                r--;
            }else if(nums[num]<target){
                l++;
            }else{
                return num;
            }
        }
        return -1;
    }
}
