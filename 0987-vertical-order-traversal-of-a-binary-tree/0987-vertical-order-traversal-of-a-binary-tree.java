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

class Pair{
    TreeNode node;
    int row;
    int col;

    Pair(TreeNode node, int row,int col)
    {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if(root == null)return  new ArrayList<>();

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root,0,0));

        while(!q.isEmpty())
        {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int row = pair.row;
            int col = pair.col;

            if(!map.containsKey(col))
            {
                map.put(col,new TreeMap<Integer,PriorityQueue<Integer>>());
            }
            if(!map.get(col).containsKey(row))
            {
                map.get(col).put(row,new PriorityQueue<Integer>());
            }
            map.get(col).get(row).offer(node.val);

            if(node.left!=null)
            {
                q.offer(new Pair(node.left,row+1,col-1));
            }
            if(node.right!=null)
            {
                q.offer(new Pair(node.right,row+1,col+1));
            }

        }

        List<List<Integer>> result = new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> row : map.values())
        {

            ArrayList<Integer> list = new ArrayList<>();

            for(PriorityQueue<Integer> queue : row.values())
            {
                while(!queue.isEmpty())
                {
                    list.add(queue.poll());
                }
            }
            result.add(list);
        }
        return result;
        
    }
}