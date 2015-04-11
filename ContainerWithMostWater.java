//correctly understand the meaning of the problem:
//it's min(height[i], height[j]) * (j-i); not min(height[k])(i <=k <= j)*(j-i)
public class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            res = Math.max(res, Math.min(height[i], height[j])*(j-i));
            if (height[i] < height[j]) {
                i++;
            } else if (height[i] > height[j]) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return res;
    }
}
