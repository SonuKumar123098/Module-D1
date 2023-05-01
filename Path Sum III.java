//https://course.acciojob.com/idle?question=4bb9061f-b7f2-4eae-aca5-d8a6e17335f8

//https://leetcode.com/problems/path-sum-iii/
class Solution {
    int cnt;
    private void findPath(TreeNode root,long target){
        if(root==null)return;
        if(root.val==target){
            cnt++;
        }
        findPath(root.left,target-root.val);
        findPath(root.right,target-root.val);
    }
    private void dfs(TreeNode root,int target){
        if(root==null) return;
        findPath(root,target);
        dfs(root.left,target);
        dfs(root.right,target);
    }
    public int pathSum(TreeNode root, int targetSum) {
        cnt=0;
        dfs(root,targetSum);
        return cnt;
    }
}
