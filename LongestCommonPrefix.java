//no need to use string builder!
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}

//another better solution
class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        if(strs.empty()) return "";
        for(int i = 0;i < strs[0].size(); ++i){
            for(int j = 1;j < strs.size(); ++j){
                if(strs[j][i] != strs[0][i]) return strs[0].substr(0,i);
            }
        }
        return strs[0];
    }
};
