class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> res= new HashMap<>();
        for(int i=0;i<=nums.length-1;i++){
            int diff=target-nums[i];// d=7-3=4
            if(res.containsKey(diff)){
                return new int[]{res.get(diff),i};
            }
            res.put(nums[i],i);
        }
        return new int[]{};
    }
}
