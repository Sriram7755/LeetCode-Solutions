class Solution {
    public int minMoves(int[] nums) {
        
        int mini = Integer.MAX_VALUE;
        for(int num : nums)
        {
            mini = Math.min(mini,num);
        }
        int total_moves = 0;

        for(int num : nums)
        {
            int diff = num - mini;
            total_moves+=diff;
        }
        return total_moves;
    }
}