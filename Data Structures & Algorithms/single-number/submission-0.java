class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        int xORR=0;
        for(int i=0;i<n;i++){
            xORR ^= nums[i];
        }
        return xORR;
        
    }
}
