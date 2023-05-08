//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//https://course.acciojob.com/idle?question=a565901c-8445-4cb5-8e0a-364907fef51e
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
}
