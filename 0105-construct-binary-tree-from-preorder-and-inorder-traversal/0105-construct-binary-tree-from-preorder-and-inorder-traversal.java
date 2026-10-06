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
    int preIndx = 0;
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode construct(int[] preorder,int[] inorder,int start, int end)
    {
        if(start>end) return null;

        int val = preorder[preIndx++];

        TreeNode root = new TreeNode(val);
        root.left = construct(preorder,inorder,start,map.get(val)-1);
        root.right = construct(preorder,inorder,map.get(val)+1,end);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }

        return construct(preorder,inorder,0,inorder.length-1);
    }
}