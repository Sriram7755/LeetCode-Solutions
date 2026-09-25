class Solution {
    public int firstUniqChar(String s) {

        char[] arr = s.toCharArray();
        if(arr.length == 1 ) return 0;
        for(int i= 0 ;i<arr.length;i++)
        {
            boolean result = true;
            for(int j = 0 ; j<arr.length ;j++)
            {
               if(i!=j && arr[i] == arr[j])
               {
                result =false;
                break;
               }

            }
            if(result)
            {
                return i;
            }
        }
        return -1;
    }
}