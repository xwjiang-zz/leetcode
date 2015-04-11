public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        long number = n;
        if (n < 0) {
            number += (1L << 32);
        }
        int count = 0;
        while (number > 0) {
            number = number & (number - 1);
            count++;
        }
        return count;
    }
}
