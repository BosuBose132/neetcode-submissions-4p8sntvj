class Solution {
    public boolean isPalindrome(int x) {
        int rev=0, num=x;
        while(num>0){
            int rem = num%10;
            rev=rev*10+rem;
            num=num/10;
        }
        if(rev==x){
            return true;
        }else{
            return false;
        }
    }
}