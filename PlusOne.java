public class Solution {
    public int[] plusOne(int[] digits) {
        int carrier = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int sum = digits[i] + carrier;
            carrier = sum/10;
            digits[i] = sum%10;
        }
        if (carrier == 0) {
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i-1];
            }
            return res;
        }
    }
}
