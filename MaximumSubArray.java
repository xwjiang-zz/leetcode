//use divide and conquer!!!
public class Solution {
   
    public int maxSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int maxSum = -1000;
        int partialSum = 0;
        for (int i = 0; i < array.length; i++) {
            partialSum = Math.max(partialSum + array[i], array[i]);
            maxSum = Math.max(maxSum, partialSum);
        }
        return maxSum;
    }


}
