class Solution {
    public int lcs(int ind1,int ind2,String s1,String s2,int[][] dp)
    {
        if(ind1<0 || ind2<0)
        {
            return 0;
        }
        if(dp[ind1][ind2] !=-1)return dp[ind1][ind2];
        if(s1.charAt(ind1) == s2.charAt(ind2))
        {
            return 1 + lcs(ind1-1,ind2-1,s1,s2,dp);
        }

         return dp[ind1][ind2] = Math.max(lcs(ind1,ind2-1,s1,s2,dp),lcs(ind1-1,ind2,s1,s2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0;i<text1.length();i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return lcs(text1.length()-1,text2.length()-1,text1,text2,dp);
        
    }
}