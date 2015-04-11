public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0) {
            return;
        }
        int i = 0;
        int j = len - k;
        for (; j < len; j++) {
            int tmp = nums[j];
            for (int x = j; x > i; x--) {
                nums[x] = nums[x-1];
            }
            nums[i++] = tmp;
        }
    }
}
