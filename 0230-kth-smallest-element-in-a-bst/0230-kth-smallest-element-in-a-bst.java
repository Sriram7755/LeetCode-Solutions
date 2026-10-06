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

    public ArrayList<Integer> inorder(TreeNode root)
    {
        ArrayList<Integer> list = new ArrayList<>();

        if(root == null)return list;
        list.addAll(inorder(root.left));
        list.add(root.val);
        list.addAll(inorder(root.right));
        return list;

    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = inorder(root);

        return list.get(k-1);
    }
}