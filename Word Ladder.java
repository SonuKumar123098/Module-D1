// https://leetcode.com/problems/word-ladder/description/
// https://practice.geeksforgeeks.org/problems/word-ladder/1
// https://course.acciojob.com/idle?question=8ca169b1-747f-49f8-8e09-189c9551efb8

class Pair{
    String word;
    int trans;
    Pair(String s,int b){
        word=s;
        trans=b;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String>words=new HashSet<>();
        for(String s:wordList) words.add(s);
        if(!words.contains(targetWord))return 0;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(startWord,1));
        while(q.size()>0){
            Pair p=q.remove();
            int trans=p.trans;
            String temp=p.word;
            if(temp.equals(targetWord)) return trans;
            for(int i=0;i<temp.length();i++){
                char[] arr=temp.toCharArray();
                for(char c='a';c<='z';c++){
                    arr[i]=c;
                    String s=String.copyValueOf(arr);
                    if(words.contains(s)){
                        q.add(new Pair(s,trans+1));
                        words.remove(s);
                    }
                }
            }
        }
        return 0;
        
    }
}
