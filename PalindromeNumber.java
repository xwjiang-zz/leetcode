//notice how weight is increased by 10 every time. the condition is x/weight >= 10 instead of x >= weight * 10! overflow
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int weight = 1;
        while (x/weight >= 10) {
            weight *= 10;
        }
        while (weight > 0) {
            int lsb = x%10;
            int msb = x/weight;
            if (lsb != msb) {
                return false;
            }
            x = x%weight/10;
            weight /= 100;
        }
        return true;
    }
}
