class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
       ArrayList<Integer> list = new ArrayList<>();

       for(int i = 0;i<nums.length;i++)
       {
        int num = Math.abs(nums[i]);
            int ind = num - 1;

            if(nums[ind]<0)
            {
                list.add(num);
            }
            else{
                nums[ind] = -nums[ind];
            }
       }
       return list;
        
    }
}