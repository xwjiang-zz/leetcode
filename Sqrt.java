//the diff between float and double
//ref: http://stackoverflow.com/questions/2386772/difference-between-float-and-double
public class Solution {
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double a = 1;
        double delta;
        do {
            delta = (a-x/a)/2;
            a -= delta;
        } while (Math.abs(delta) > 0.00000000001);
        return (int)a;
    }
}
