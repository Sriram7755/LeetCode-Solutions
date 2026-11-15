
class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd = 0;
        int even = 0;
        int ans = 0;

        for (int num : arr) {
            if (num % 2 != 0) {
                int temp = odd;
                odd = even + 1;
                even = temp;
            } else {
                even = even + 1;
            }

            ans = (ans + odd) % 1000000007;
        }

        return ans;
    }
}
