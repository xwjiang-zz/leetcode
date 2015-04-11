public class Solution {
    public int reverse(int x) {
        long num = 0L;
        while (x != 0) {
            num *= 10;
            num += x % 10;
            x /= 10;
        }
        if (num > (long)Integer.MAX_VALUE || num < (long)Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int)num;
        }
    }
}
