class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        Map<Character,Character> res= new HashMap<>();
        res.put(')','(');
        res.put('}','{');
        res.put(']','[');
        for(char ch: s.toCharArray()){
            if(res.containsKey(ch)){
                if(!st.isEmpty() && st.peek()==res.get(ch)){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
}
