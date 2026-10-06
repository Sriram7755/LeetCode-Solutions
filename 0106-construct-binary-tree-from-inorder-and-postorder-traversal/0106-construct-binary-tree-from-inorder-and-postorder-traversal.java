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

    HashMap<Integer,Integer> map = new HashMap<>();
    int postIndx;

    public TreeNode construct(int[] inorder,int[] postorder, int start,int end)
    {
        if(start>end)return null;
        

        int val = postorder[postIndx--];

        TreeNode root = new TreeNode(val);

        root.right = construct(inorder,postorder,map.get(val)+1,end);
        root.left = construct(inorder,postorder,start,map.get(val)-1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i = 0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        postIndx = postorder.length-1;
        return construct(inorder,postorder,0,inorder.length-1);
        
    }
}