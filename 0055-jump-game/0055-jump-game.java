class Solution {
    public boolean calculate(int ind , int[] nums,Boolean[] dp)
    {
        if(ind == nums.length-1)
        {
            return true;
        }

        if(dp[ind]!=null)return dp[ind] == true;
        
        for(int jump = 1;jump<=nums[ind];jump++)
        {
            int next = ind+jump;
            if(calculate(next,nums,dp))return dp[ind] =  true;
        }

        return dp[ind] = false;
    }
    public boolean canJump(int[] nums) {

        Boolean[] dp = new Boolean[nums.length];
        return calculate(0,nums,dp);
    }
}