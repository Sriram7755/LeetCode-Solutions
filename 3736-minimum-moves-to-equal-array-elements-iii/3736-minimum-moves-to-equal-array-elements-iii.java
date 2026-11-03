class Solution {
    public int minMoves(int[] nums) {
        int mini = Integer.MIN_VALUE;
        for(int num : nums)
        {
            mini = Math.max(num,mini);
        }
        int total = 0;

        for(int num : nums)
        {
            int diff = mini - num;
            total+=diff;
        }
        return total;
    }
}