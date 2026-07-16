class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> res= new HashMap<>();
        for(int num: nums){
          res.put(num,res.getOrDefault(num,0)+1);
        }
        List<int[]> output = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : res.entrySet()){
          output.add(new int[]{entry.getValue(),entry.getKey()});
        } 
        output.sort((a,b) -> b[0]-a[0]);
        int[] freq=new int[k];
        for(int j=0;j<k;j++){
          freq[j]= output.get(j)[1];
        }
        return freq;
        
        
    }
}
