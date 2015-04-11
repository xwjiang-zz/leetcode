public class Solution {
    public int removeDuplicates(int[] A) {
        int i, j;
        for (i = 1, j = 1; j < A.length; j++) {
            if (A[j] != A[j-1]) {
                A[i++] = A[j];
            }
        }
        return A.length == 0 ? 0 : i;
    }
}
    
/*
old solution:
  1   public int removeDuplicates(int[] A) {
  2     int i, j;
  3     for (i = 0, j = 0; j < A.length; j++) {
  4       if (i < 1 || ((i >=1 ) && A[i-1] != A[j])) {
  5         A[i++] = A[j];
  6       }
  7     }
  8     return i;
  9   }
*/

//3/21/2015
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        while (j < A.length) {
            if (A[i] == A[j]) {
                j++;
            } else {
                A[++i] = A[j++];
            }
        }
        return i+1;
    }
}
