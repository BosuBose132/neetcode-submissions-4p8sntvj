class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j= numbers.length-1;
        int sum;
        while(i<j){
            while(i<j){
            if(numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }else{
                j--;
            }
            }
            j=numbers.length-1;
            i++;
        }
        return new int[0];
    }
}
