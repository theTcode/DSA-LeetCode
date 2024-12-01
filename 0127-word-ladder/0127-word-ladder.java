class Pair{
    String word;
    int step;
    Pair(String _word, int _step){
        this.word = _word;
        this.step = _step;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> st = new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().word;
            int step = q.peek().step;
            q.remove();
            if(word.equals(endWord)==true){
                return step;
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(st.contains(replacedWord)==true){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, step+1));
                    }
                }
            }
        }
        return 0;
    }
}