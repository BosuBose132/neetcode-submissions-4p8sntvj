class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, r=0;
        for(int pile:piles){
            r=Math.max(pile,r);
        }
        while(l<r){
            int mid=l+(r-l)/2;
            long totalspeed=0;
            for(int pile: piles){
            totalspeed+=(long)Math.ceil((double)pile/mid);
            }
            if(totalspeed>h){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}
