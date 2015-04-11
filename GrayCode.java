//pay attention to possible loss of precision error!
//pow takes two doubles and return one double

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for (int i = 1; i <= n; i++) {
            int num = (int)Math.pow(2, i-1);
            for (int j = num - 1; j >= 0; j--) {
                res.add(res.get(j) + num);
            }
        }
        return res;
    }
}


//2nd bit manipulation
//pay attention to shift operation

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for (int i = 1; i < 1 << n; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}


//4/4/2015
//use count to keep track of how many valid numbers in res

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        int count = 1;
        for (int round = 0; round < n; round++) {
            for (int i = count-1; i >= 0; i--) {
                res.add(count+res.get(i));
            }
            count = count << 1;
        }
        return res;
    }
}
