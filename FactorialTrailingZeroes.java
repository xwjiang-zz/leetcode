public class Solution {
    public int trailingZeroes(int n) {
        while (n%5 != 0) {
            n--;
        }
        int count = 0;
        for (long i = 5L; i <= n; i = i*5) {
            count += n/i;
        }
        return count;
    }
}
