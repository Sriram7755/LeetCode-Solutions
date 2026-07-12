class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int r = 0;
        int l =0;
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;

        while(r<n)
        {
            if(!set.contains(s.charAt(r)))
            {
                set.add(s.charAt(r));
                maxLen = Math.max(maxLen,r-l+1);
                r++;
            }
            else{
                set.remove(s.charAt(l));
                l++;
            }
        }

        return maxLen;
        
    }
}