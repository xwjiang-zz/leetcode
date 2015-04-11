//integer range
public class Solution {
    public double pow(double x, int n) {
        return _pow(x, (long)n);
    }
    public double _pow(double x, long n) {
        if (n == 0) {
            return (double)1;
        } else if (n < 0) {
            return 1.0/_pow(x, -n);
        } else {
            double tmp = _pow(x, n/2);
            if (n%2 == 0) {
                return tmp*tmp;
            } else {
                return tmp*tmp*x;
            }
        }
    }
}
