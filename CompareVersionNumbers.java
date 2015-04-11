//my solution
//another solution that's more concise. ref:https://github.com/leetcoders/LeetCode/blob/master/CompareVersionNumbers.h
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] tokens1 = version1.split("\\.");
        int len1 = tokens1.length;
        String[] tokens2 = version2.split("\\.");
        int len2 = tokens2.length;
        for (int i = 0; i < len1 && i < len2; i++) {
            if (Integer.parseInt(tokens1[i]) > Integer.parseInt(tokens2[i])) {
                return 1;
            } else if (Integer.parseInt(tokens1[i]) < Integer.parseInt(tokens2[i])) {
                return -1;
            }
        }
        if (len1 == len2) {
            return 0;
        } else if (len1 > len2) {
            for (int i = len2; i < len1; i++) {
                if (Integer.parseInt(tokens1[i]) > 0) {
                    return 1;
                }
            }
            return 0;
        } else {
            for (int i = len1; i < len2; i++) {
                if (Integer.parseInt(tokens2[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        }
    }
}

class Solution {
public:
    int compareVersion(string version1, string version2) {
        int v1len = version1.size(), v2len = version2.size();
        for (int i = 0, j = 0; (i < v1len || j < v2len); ) {
            long long a = 0, b =0;
            while (i < v1len && version1[i] != '.') {
                a = a * 10 + version1[i++] - '0';
            }
            ++i;
            while (j < v2len && version2[j] != '.') {
                b = b * 10 + version2[j++] - '0';
            }
            ++j;
            if (a > b) return 1;
            if (a < b) return -1;
        }
        return 0;
    }
};
