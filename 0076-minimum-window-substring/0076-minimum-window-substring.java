class Solution {
    public String minWindow(String s, String t) {
        
        int[] freq = new int[256];

        for(char ch : t.toCharArray())
        {
            freq[ch]++;
        }
        
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0; 
        int left = 0;

        for(int right = 0;right<s.length();right++)
        {
            char ch = s.charAt(right);

            if(freq[ch]>0)
            {
                required--;
            }
            freq[ch]--;

            while(required == 0)
            {
                int len = right - left+1;
                if(len<minLen)
                {
                    minLen = len;
                    start = left;
                }
                char c = s.charAt(left);
                freq[c]++;
                if(freq[c]>0)
                {
                    required++;
                }
                left++;
            }

        }

        return minLen == Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}