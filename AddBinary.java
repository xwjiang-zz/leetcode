//stringbuilder insert method: sb.insert(0, 1.32) will actually insert 1.32 into the sb
public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carrier = 0;
        StringBuilder sb = new StringBuilder();
        for (; i >= 0 || j >= 0; i--, j--) {
            if (i >= 0) {
                carrier += a.charAt(i) - '0';
            }
            if (j >= 0) {
                carrier += b.charAt(j) - '0';
            }
            /*
            sb.insert(0, carrier%2);
            carrier /= 2;
            */
            //use bit manipulation
            sb.insert(0, carrier&1);
            carrier = carrier >> 1;
        }
        if (carrier != 0) {
            sb.insert(0, carrier);
        }
        return sb.toString();
    }
}
