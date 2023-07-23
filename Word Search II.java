// https://course.acciojob.com/idle?question=a9053e1c-c112-4494-b77d-6c22f107cee2
// https://leetcode.com/problems/word-search-ii/description/

class TrieNode{
	TrieNode[]child;
  int cnt;
	String end;
	public TrieNode(){
		child=new TrieNode[26];
    cnt=0;
		end="";
	}
}
class Trie{
	TrieNode root;
	public Trie(){
		root=new TrieNode();
	}
	void insert(String str){
        TrieNode node=root;
        char[]arr=str.toCharArray();
        for(int i=0;i<str.length();i++){
            char c=arr[i];
            if(node.child[c-'a']==null){
                node.cnt++;
                node.child[c-'a']=new TrieNode();
            }
            node=node.child[c-'a'];
        }
				node.end=str;
    }
}
class Solution {
    private boolean valid(int m,int n,int i,int j){
		if(i<0||i>=m||j<0||j>=n) return false;
		return true;
	  }
    private void solve(List<String>ans,char[][]board,boolean[][]visited,int i,int j,TrieNode root){
	TrieNode node=root.child[board[i][j]-'a'];
	
	if(node==null) return;
	visited[i][j]=true;
	if(!node.end.equals("")){
		ans.add(node.end);
		node.end="";
	}
	for(int d=0;d<4;d++){
		int x=i+dirn[d][0];
		int y=j+dirn[d][1];
		if(valid(board.length,board[0].length,x,y)){
			if(!visited[x][y] && root.cnt!=0){
				solve(ans,board,visited,x,y,node);
			}
		}
	}
	if(node.cnt==0){
		root.cnt--;
	}
	visited[i][j]=false;

}
 int [][]dirn=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public List<String> findWords(char[][] board, String[] words) {
        
        int m=board.length;
	    int n=board[0].length;
        List<String>ans=new ArrayList<>();
        Trie T=new Trie();
				TrieNode root=T.root;
        for(int k=0;k<words.length;k++){
            T.insert(words[k]);
        }
				boolean [][]visited=new boolean[m][n];
		    for(int i=0;i<m;i++){
			    for(int j=0;j<n;j++){
				    if(!visited[i][j]){
					    solve(ans,board,visited,i,j,root);
				    }
			    }
		    }
		 return ans;
    }
}
