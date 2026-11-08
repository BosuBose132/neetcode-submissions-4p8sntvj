class Solution {
    public String reorganizeString(String s) {
        //frequency of each character  //axyy
        int[] freq= new int[26]; //[- - - - - -26]
        for(char str: s.toCharArray()){
            freq[str-'a']++; // y(24)=2, a(0)=1, x(23)=1
        }

        //Max frequency
        int max=0, letter=0 ;
        for(int i=0;i<freq.length;i++){
            if(freq[i]>max){ //2>1
                max=freq[i]; // 2
                letter=i; //24
            }
        }

        char[] res=new char[s.length()]; //4
        if(max>(res.length+1)/2) return "";

        //Place the max freq characters in the result alternative places
        int idx=0;
        while(freq[letter]-- > 0){ //2>0 //1 //0
            res[idx] = (char)(letter + 'a'); //y - y - 
            idx +=2;  //4
        }

        //place the remaining chars
        for(int i=0;i<freq.length;i++){
            while(freq[i]-- > 0){ 
                if(idx >= res.length) idx=1;
                res[idx]= (char)(i+'a'); //y a y _ 
                idx += 2; //3
            }
        }
        return new String(res);

    }
}