//thought of a O(n2) algo
//but to reverse an array, only O(n) is needed
public class Solution {
    public void nextPermutation(int[] num) {
        int i;
        for (i = num.length - 2; i >= 0; i--) {
            if (num[i+1] > num[i]) {
                break;
            }
        }
        int j = i + 1;
        int k = num.length - 1;
        while (j < k) {
            int tmp = num[j];
            num[j] = num[k];
            num[k] = tmp;
            j++;
            k--;
        }
        if (i >= 0) {
            for (j = i + 1; j < num.length; j++) {
                if (num[j] > num[i]) {
                    int tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                    break;
                }
            }
        }
    }
}
