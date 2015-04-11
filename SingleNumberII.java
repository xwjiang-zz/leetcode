//for a single bit, %3 will tell us whether this bit is 0 or 1
public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
        for (int n = 0; n < 32; n++) {
            int bitSum = 0;
            for (int i = 0; i < A.length; i++) {
                bitSum += (A[i] >> n) & 1;
            }
            res += (bitSum % 3) << n;
        }
        return res;
    }
}
