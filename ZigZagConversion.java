//notice to separate the case nRows = 1!
public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int period = 2*(nRows-1);
        for (int i = 0; i < s.length(); i += period) {
            sb.append(s.substring(i, i+1));
        }
        for (int i = 1; i < nRows-1; i++) {
            int j = i;
            int k = period - i;
            for (; k < s.length(); j += period, k += period) {
                sb.append(s.substring(j, j+1));
                sb.append(s.substring(k, k+1));
            }
            if (j < s.length()) {
                sb.append(s.substring(j, j+1));
            }
        }
        for (int i = nRows - 1; i < s.length(); i += period) {
            sb.append(s.substring(i, i+1));
        }
        return sb.toString();
    }
}
