//together with Next Permutation!
public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder num = new StringBuilder();
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            num.append(i);
            fac *= i;
        }
        StringBuilder res = new StringBuilder();
        k--;
        while (n > 0) {
            fac /= n;
            int i = k / fac;
            k = k % fac;
            res.append(num.charAt(i));
            num.deleteCharAt(i);
            n--;
        }
        return res.toString();
    }
}

public class Solution {
    public String getPermutation(int n, int k) {
        k--;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }   
        int fac = 1;
        for (int i = 1; i <= n-1; i++) {
            fac *= i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i >= 1; i--) {
            int num = k / fac;
            k = k % fac;
            fac = fac / i;
            sb.append(list.get(num));
            list.remove(num);
        }
        sb.append(list.get(0));
        return sb.toString();
    }
}
