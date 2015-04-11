//A[i] = i
public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        int i = 0;
        while (i < A.length) {
            if (A[i] < 0 || A[i] >= A.length || A[i] == i || A[A[i]] == A[i]) {
                i++;
                continue;
            } else {
                int tmp = A[A[i]];
                A[A[i]] = A[i];
                A[i] = tmp;
            }
        }
        for (i = 1; i < A.length; i++) {
            if (A[i] != i) {
                break;
            }
        }
        if (A[0] == i) {
            return i+1;
        } else {
            return i;
        }
    }
}

//A[i] = i+1 is more concise
public class Solution {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] <= 0 || A[i] > A.length || A[i] == i+1 || A[A[i]-1] == A[i]) {
                i++;
            } else {
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }
        for (i = 0; i < A.length; i++) {
            if (A[i] != i+1) {
                break;
            }
        }
        return i+1;
    }
}

//3/23/2015
public class Solution {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int mov = A[i];
            while (mov > 0 && mov <= A.length && A[mov-1] != mov) {
                int next = A[mov-1];
                A[mov-1] = mov;
                mov = next;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i+1) {
                return i+1;
            }
        }
        return A.length+1;
    }
}
