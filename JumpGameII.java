//my solution
public class Solution {
    public int jump(int[] A) {
        if (A.length == 1) {
            return 0;
        }
        int last = -1;
        int current = 0;
        int count = 0;
        while (last < current) {
            count++;
            int next = current;
            for (int k = last+1; k <= current; k++) {
                next = Math.max(next, A[k]+k);
            }
            last = current;
            current = next;
            if (current >= A.length - 1) {
                return count;
            }
        }
        return -1;
    }
}

//another better one
    int jump_2(int A[], int n) {
        if(n==1) return 0;
        int res = 0;
        int last = 0;
        int cur = 0;
        for(int i=0;i<n;i++){
            if(i>last){
                last = cur;
                ++res;
                if (cur >= n - 1) break;
            }
            cur = max(cur,i+A[i]);
        }
        return res;
    }


//3/25/2015
public class Solution {
    public int jump(int[] A) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < A.length - 1) {
            int k = j;
            for (; i <= j; i++) {
                k = Math.max(k, A[i]+i);
            }
            count++;
            j = k;
            if (count == A.length) {
                return -1;
            }
        }
        return count;
    }
}

