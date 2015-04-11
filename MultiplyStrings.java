//StringBuilder API: insert(int, char), append, deleteCharAt(int)
public class Solution {
    public String multiply(String num1, String num2) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num1.length() + num2.length() - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j >= num1.length()) {
                    continue;
                } else if (j >= num2.length()) {
                    break;
                }
                num += (num1.charAt(num1.length() - 1 - i + j) - '0') * (num2.charAt(num2.length() - 1 - j) - '0');
            }
            sb.insert(0, (char)(num%10 + '0'));
            num /= 10;
        }
        if (num != 0) {
            sb.insert(0, (char)(num + '0'));
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
//3/24/2015
//use int[] res = new int[l1+l2-1] as a intermediate state
//pay special attention to if the result is 0
public class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] res = new int[l1+l2-1];
        for (int i = l1-1; i >= 0; i--) {
            for (int j = l2-1; j >= 0; j--) {
                int pos = l1-1-i+l2-1-j;
                res[pos] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                if (pos+1 < l1+l2-1) {
                    res[pos+1] += res[pos]/10;
                    res[pos] = res[pos] % 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = l1+l2-2;
        while (i >= 0 && res[i] == 0) {
            i--;
        }
        if (i == -1) {
            return "0";
        }
        for (; i >= 0; i--) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}

