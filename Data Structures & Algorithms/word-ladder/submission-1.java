class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set= new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> q= new LinkedList<>();
        q.offer(beginWord);
        q.offer(null);

        set.remove(beginWord);
        int level=1;
        while(!q.isEmpty()){
            String word=q.poll();

            if(word==null){
                level++;
            if(!q.isEmpty()){
                q.offer(null);
            }
            continue;
            }
            if(word.equals(endWord)) return level;
            for(int i=0;i<word.length();i++){
            char[] chars= word.toCharArray();//{h,o,t}
            for(char c='a';c<='z';c++){
                chars[i]= c;
                String newWord= new String(chars);
                if(set.contains(newWord)){
                    q.offer(newWord);
                    set.remove(newWord);
                }
            }
        }
        }
        return 0;
    }
}
