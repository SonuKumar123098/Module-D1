//https://leetcode.com/problems/binary-tree-coloring-game/
class Solution {
    private boolean ans;
	private int solve(TreeNode root,int n,int x){
		if(root==null) return 0;
		int left=solve(root.left,n,x);
		int right=solve(root.right,n,x);
		if(root.val==x){
			if(n>2*(left+right+1)) ans=true;
			else if(left>(n-left)) ans=true;
			else if(right>(n-right)) ans=true;
		}
		return left+right+1;
	}
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        ans=false;
		solve(root,n,x);
		return ans;
    }
}
