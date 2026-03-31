class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet <Integer> seen= new HashSet<>();
        int i =0;
        while(i<nums.length){
            if(seen.contains(nums[i])){
                return true;
            }else{
                seen.add(nums[i]);
                i++;
            }
        }
        return false;
    }
}