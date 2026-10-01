class Solution {
    public int maxJump(int[] stones) {
        
        int ans = 0;

        for(int i = 0;i<stones.length-2;i++)
        {
            ans = Math.max(ans, stones[i+2] - stones[i]);
        }
        return Math.max(ans,stones[1] - stones[0]);
    }
}