//1st time solution
public class Solution {
    public static List<String> restoreIpAddresses(String s) {
        return restoreParts(s, 4);
    }
    public static List<String> restoreParts(String s, int part) {
        List<String> res = new ArrayList<String>();
        if (part == 0) {
            if (s.length() == 0) {
                res.add("");
            }
            return res;
        }
        for (int len = 1; len <= Math.min(3, s.length()); len++) {
            String numStr = s.substring(0, len);
            int num = Integer.parseInt(numStr);
            if (num < 256 && (numStr.charAt(0) != '0' || numStr.length() == 1)) {
                List<String> subRes = restoreParts(s.substring(len), part - 1);
                for (String sub : subRes) {
                    if (sub.length() > 0) {
                        res.add(numStr + "." + sub);
                    } else {
                        res.add(numStr);
                    }
                }
            }
        }
        return res;
    }
}


//2nd time solution
//stringbuilder delte function; 
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<String>();
        _restoreIpAddresses(s, 0, 0, sb, res);
        return res;
    }
    public void _restoreIpAddresses(String s, int index, int count, StringBuilder sb, List<String> res) {
        if (count == 4) {
            if (index == s.length()) {
                sb.deleteCharAt(index+count-1);
                res.add(sb.toString());
                sb.append(".");
            }
            return;
        }
        int num = 0;
        for (int i = 1; index + i <= s.length(); i++) {
            num *= 10;
            num += s.charAt(index + i - 1) - '0';
            if (num <= 255) {
                sb.append(s.substring(index, index+i));
                sb.append(".");
                _restoreIpAddresses(s, index + i, count + 1, sb, res);
                sb.delete(index+count, index+count+i+1);
            } else{
                return;
            }
            if (num == 0) {
                return;
            }
        }
    }
}

//4/5/2014
//more clear
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int[] pos = new int[4];
        restoreRec(s, pos, res, 0, 0);
        return res;
    }
    public void restoreRec(String s, int[] pos, List<String> res, int seg, int count) {
        if (seg == 4 && count == s.length()) {
            String toAdd = s.substring(0, pos[0]) + "."
                        + s.substring(pos[0], pos[0]+pos[1]) + "."
                        + s.substring(pos[0]+pos[1], pos[0]+pos[1]+pos[2]) + "."
                        + s.substring(pos[0]+pos[1]+pos[2], pos[0]+pos[1]+pos[2]+pos[3]);
            res.add(toAdd);
        } else if (seg == 4 || count == s.length()) {
            return;
        } else if (s.charAt(count) == '0') {
            pos[seg] = 1;
            restoreRec(s, pos, res, seg+1, count+1);
        } else {
            int num = 0;
            for (int i = 1; count + i <= s.length() && i <= 3; i++) {
                num *= 10;
                num += s.charAt(count+i-1) - '0';
                if (num >= 1 && num <= 255) {
                    pos[seg] = i;
                    restoreRec(s, pos, res, seg+1, count+i);
                }
            }
        }
    }
}

