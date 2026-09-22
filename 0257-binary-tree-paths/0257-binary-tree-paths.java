/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<String> list = new ArrayList<>();

    public void leaf(TreeNode root,String path)
    {
        if(root == null)return ;
        path+=root.val;
        if(root.left == null && root.right == null){
            list.add(path);
            return;
        }
        path+="->";

        leaf(root.left,path);
        leaf(root.right,path);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)return list;

        leaf(root,"");
        return list;
    }
}