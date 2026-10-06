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
    int sum = 0;
    public void dfs(TreeNode root , int current_sum)
    {
        if(root == null)return ;

        current_sum = (current_sum *10) + root.val;
        if(root.left == null && root.right == null)
        {
            sum+=current_sum;
        }
        dfs(root.left,current_sum);
        dfs(root.right,current_sum);
    }
    public int sumNumbers(TreeNode root) {
        if(root == null)return sum;

        dfs(root,0);
        return sum;
    }
}