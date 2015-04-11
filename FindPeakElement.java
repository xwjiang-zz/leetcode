//always keep in mind the binary search method!!
public class Solution {
    public int findPeakElement(int[] num) {
        int i = 0;
        int j = num.length - 1;
        while (i <= j) {
            int m = (i+j)/2;
            if ((m == 0 || num[m] > num[m-1]) && (m == num.length - 1 || num[m] > num[m+1])) {
                return m;
            } else if (m > 0 && num[m] < num[m-1]) {
                j = m-1;
            } else {
                i = m+1;
            }
        }
        return -1;
    }
}
