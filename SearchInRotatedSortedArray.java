//binary search
//criteria to judge which way to go!
public class Solution {
    public int search(int[] A, int target) {
        return _search(A, 0, A.length - 1, target);
    }
    public int _search(int[] A, int m, int n, int target) {
        if (m > n) {
            return -1;
        }
        int mid = (m + n) / 2;
        if (A[mid] == target) {
            return mid;
        }
        if (A[m] <= A[mid]) {
            return target < A[mid] && target >= A[m] ? _search(A, m, mid-1, target) : _search(A, mid+1, n, target);
        } else {
            return target <= A[n] && target > A[mid] ? _search(A, mid+1, n, target) : _search(A, m, mid-1, target);
        }
    }
}

//3/21/2015
public class Solution {
    public int search(int[] A, int target) {
        int i = 0;
        int j = A.length - 1;
        while (i <= j) {
            int m = (i + j)/2;
            if (A[m] == target) {
                return m;
            }
            if (A[i] <= A[m]) {
                if (A[i] <= target && target < A[m]) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            } else if (A[m] <= A[j]) {
                if (A[m] < target && target <= A[j]) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
        }
        return -1;
    }
}
