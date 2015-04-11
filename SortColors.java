public class Solution {
    public void sortColors(int[] A) {
        int n = A.length;
        int start0 = 0;
        int end2 = n - 1;
        int i = 0;
        while (i <= end2) {
            if (A[i] == 0) {
                A[i++] = 1;
                A[start0++] = 0;
            } else if (A[i] == 2) {
                int tmp = A[end2];
                A[end2--] = 2;
                A[i] = tmp;
            } else {
                i++;
            }
        }
    }
}

//3/30/2015
public class Solution {
    public void sortColors(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int i = 0;
        while (i <= end) {
            if (A[i] == 0) {
                A[i++] = 1;
                A[start++] = 0;
            } else if (A[i] == 2) {
                A[i] = A[end];
                A[end--] = 2;
            } else {
                i++;
            }
        }
    }
}
