public class Solution {
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long res = 0;
        while (a >= b) {
            long b0 = b;
            long c = 1;
            while (a >= b + b) {
                b <<= 1;
                c <<= 1;
            }
            res += c;
            a -= b;
            b = b0;
        }
        res = (dividend > 0)^(divisor > 0) ? -res : res;
        if (res < (long)Integer.MAX_VALUE) {
            return (int)res;
        } else {
            return Integer.MAX_VALUE;
        }
    }
}

//3/21/2015
public class Solution {
    public int divide(int dividend, int divisor) {
        long d1 = dividend;
        long d2 = divisor;
        d1 = Math.abs(d1);
        d2 = Math.abs(d2);
        long res = 0;
        while (d1 >= d2) {
            long div = d2;
            long res1 = 1;
            while (d1 >= (div << 1)) {
                res1 = res1 << 1;
                div = div << 1;
            }
            d1 = d1 - div;
            res += res1;
        }
        if ((dividend >= 0) ^ (divisor > 0)) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int)res;
        }
    }
}
