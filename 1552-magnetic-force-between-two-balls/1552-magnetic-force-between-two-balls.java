class Solution {
    
    public int possible(int[] position, int limit)
    {
        int count = 1;
        int d = position[0];

        for(int i = 1;i<position.length;i++)
        {
            if(position[i] - d >= limit)
            {
                count++;
                d = position[i];
            }
        }
        return count;

    }
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);

        int n = position.length;
        int low = 1;
        int high = position[n-1] - position[0];
        int ans = -1;

        while(low<=high)
        {
            int mid = low+(high-low)/2;

            int count = possible(position,mid);
            if(count >= m)
{
    ans = mid;
    low = mid + 1;
}
else
{
    high = mid - 1;
}

        }
        return ans;
        
    }
}