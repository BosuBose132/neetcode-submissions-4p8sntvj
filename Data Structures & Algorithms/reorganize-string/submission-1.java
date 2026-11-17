class Solution {
    public String reorganizeString(String s) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }//y=2,a=1,x=1
        int max=0,letter=0;

        //find max
        for(int i=0;i<freq.length;i++){
        if(freq[i]>max){
            max= freq[i];
            letter=i;
        }
        }
        //eliminate case-1
        if(max>(s.length()+1)/2) return "";

        //create a res array to store
        char[] res= new char[s.length()];
        int idx=0;
        //start putting the max letters 
        while(freq[letter] > 0){
            res[idx]=(char)(letter+'a');
            idx += 2;
            freq[letter]--;
        }
        //y_y_ a=0,x=23
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                if(idx>=s.length()) idx=1;
            res[idx]=(char)(i+'a');
            idx+=2;
            freq[i]--;
            }
        }
        return new String(res);
    }
}