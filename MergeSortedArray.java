//1st version
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < m + i && A[j] <= B[i]) {
                j++;
            }
            for (int k = m + i; k > j; k--) {
                A[k] = A[k-1];
            }
            A[j] = B[i];
        }
    }
}

//2nd version
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int k = m + n -1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (B[j] >= A[i]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
}

//3rd version
//notice to check whether i < 0 in the while loop
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i < 0 || B[j] >= A[i]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }
    }
}
