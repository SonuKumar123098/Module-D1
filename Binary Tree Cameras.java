//https://leetcode.com/problems/binary-tree-cameras/description/
class Solution {
    Set<TreeNode>monitored;
    int camera;
    public int minCameraCover(TreeNode root) {
        monitored=new HashSet<>();
        camera=0;
        monitored.add(null);
        solve(root,null);
        return camera;
    }
    private void solve(TreeNode node, TreeNode parent){
        if(node==null)return;
        solve(node.left,node);
        solve(node.right,node);
        if((parent==null && !monitored.contains(node)) || !monitored.contains(node.left) || !monitored.contains(node.right)){
            camera++;
            monitored.add(node);
            monitored.add(parent);
            monitored.add(node.left);
            monitored.add(node.right);
        }
    }
}
