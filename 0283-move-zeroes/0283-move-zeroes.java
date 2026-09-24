class Solution {
    public void moveZeroes(int[] nums) {
        
        int ind = -1;

        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == 0) {
                ind = i;
                break;
            }
        }

        if(ind == -1)return ;
        int j = ind+1;

        while(j<nums.length)
        {
            if(nums[j]!=0)
            {
                nums[ind] = nums[j];
                nums[j] = 0;
                ind++;
                j++;
            }
            else{
                j++;
            }
        }

        return ;
    }
}