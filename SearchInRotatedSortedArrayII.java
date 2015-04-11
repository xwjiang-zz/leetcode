public class Solution {
    public boolean search(int[] A, int target) {
        return _search(A, 0, A.length - 1, target);
    }
    public boolean _search(int[] A, int m, int n, int target) {
        if (m > n) {
            return false;
        }
        int mid = (m + n) / 2;
        if (A[mid] == target) {
            return true;
        }
        if (A[m] == A[mid] && A[mid] == A[n]) {
            return _search(A, m, mid-1, target) || _search(A, mid+1, n, target);
        }
        if (A[m] <= A[mid]) {
            return target < A[mid] && target >= A[m] ? _search(A, m, mid-1, target) : _search(A, mid+1, n, target);
        } else {
            return target <= A[n] && target > A[mid] ? _search(A, mid+1, n, target) : _search(A, m, mid-1, target);
        }
    }
}

//iteration method
public class Solution {
    public boolean search(int[] A, int target) {
        int i = 0;
        int j = A.length - 1;
        while (i <= j) {
            int mid = (i + j)/2;
            if (A[mid] == target) {
                return true;
            }
            if (A[i] == A[mid] && A[mid] == A[j]) {
                i++;
                j--;
                continue;
            }
            if (A[i] <= A[mid]) {
                if (A[i] <= target && target <= A[mid]) {
                    j = mid-1;
                } else {
                    i = mid+1;
                }
            }
            if (A[mid] <= A[j]) {
                if (A[mid] <= target && target <= A[j]) {
                    i = mid+1;
                } else {
                    j = mid-1;
                }
            }
        }
        return false;
    }
}
