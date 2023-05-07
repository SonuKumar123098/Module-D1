//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
class Solution {
    int ans=Integer.MIN_VALUE;
    int solve(TreeNode root){
        if(root==null) return 0;
        int left=solve(root.left);
        int right=solve(root.right);
        ans=Math.max(ans,left+right+root.val);
        int value= Math.max(left,right)+root.val;
        return value>0?value:0;
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }
}
