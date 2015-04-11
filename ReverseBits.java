//notice how n is treated as an unsigned value
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long number;
        if (n < 0) {
            number = n + (1L << 32);
        } else {
            number = n;
        }
        long res = 0;
        for (int i = 0; i < 32; i++) {
            res = res * 2 + number % 2;
            number /= 2;
        }
        return (int)res;
    }
}
