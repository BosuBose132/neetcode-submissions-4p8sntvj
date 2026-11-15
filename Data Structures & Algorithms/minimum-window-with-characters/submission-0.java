class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        int[] freq = new int[256];
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)]++;
        }
        int l=0,r=0;
        int count=0;
        int minLength= Integer.MAX_VALUE;
        int startIndex=-1;
        while(r<s.length()){
            if(freq[s.charAt(r)]>0){
                count++;  
            }
            freq[s.charAt(r)]--;
            while(count==t.length()){
                if(r-l+1<minLength){
                    startIndex=l;
                    minLength= r-l+1;
                }
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)]>0){
                    count--;
                } 
                l++;
            }
            r++;
        }
        return startIndex == -1?"":s.substring(startIndex,startIndex + minLength);
    }
}
