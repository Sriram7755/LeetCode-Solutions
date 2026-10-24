class Solution {
    public int expand(String s , int left , int right)
    {
        StringBuilder sb = new StringBuilder();
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right))
        {
           
            left--;
            right++;
        }
        return right - left - 1;
    }
    public String longestPalindrome(String s) {
        
        int maxLen = 0;
        String str = "";

        for(int i = 0;i<s.length();i++)
        {
            int one = expand(s,i,i);
            int two = expand(s,i,i+1);
            int maxi = Math.max(one,two);
            if(maxLen < maxi)
            {
                str = s.substring(i - (maxi - 1) / 2,
                  i + maxi / 2 + 1);
                maxLen = maxi;
            }
        }
        return str;
    }
}