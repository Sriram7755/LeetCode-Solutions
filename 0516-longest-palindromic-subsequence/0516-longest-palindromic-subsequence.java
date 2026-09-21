class Solution {

    public int calculate(String s1,String s2, int ind1,int ind2,int[][] dp)
    {
        if(ind1< 0 || ind2 < 0)return 0;
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];

        if(s1.charAt(ind1) == s2.charAt(ind2)) return dp[ind1][ind2] = 1+ calculate(s1,s2,ind1-1,ind2-1,dp);

        return dp[ind1][ind2] = Math.max(calculate(s1,s2,ind1-1,ind2,dp) , calculate(s1,s2,ind1,ind2-1,dp));


    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);

        int[][] dp = new int[s.length()][s.length()];

        for(int i = 0;i<s.length();i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return calculate(s,sb.reverse().toString(),s.length()-1,s.length()-1,dp);
    }
}