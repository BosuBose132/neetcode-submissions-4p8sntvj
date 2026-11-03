class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> res= new HashMap<>();
        for(int num: nums){
            res.put(num, res.getOrDefault(num,0)+1);
        }
        List<int[]> output = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: res.entrySet()){
            output.add(new int[]{entry.getKey(),entry.getValue()});
        }
        output.sort((a,b) -> b[1]-a[1]);
        int[] freq = new int [k];
        for(int j=0;j<k;j++){
            freq[j]=output.get(j)[0];
        }
        return freq;
    }
}
