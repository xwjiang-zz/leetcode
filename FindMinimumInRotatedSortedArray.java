//my solution
public class Solution {
    public int findMin(int[] num) {
        int i = 0;
        int j = num.length - 1;
        while (i < j) {
            int m = (i+j)/2;
            if (num[m] < num[j]) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return num[i];
    }

//another better
class Solution {
public:
    int findMin(vector<int> &num) {
        if(num.empty()) return 0;
        int size = num.size();
        int left = 0;
        int right = size - 1;
        while (left < right && num[left] >= num[right]) {
            int mid = (left + right) / 2;
            if (num[mid] > num[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return num[left];
    }
};}
