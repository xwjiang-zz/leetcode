//typical array scan operation. what to remember and what not to. proper structure: StringBuffer
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        int count = words[0].length();
        StringBuilder sb = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (count + words[i].length() + 1 <= L) {
                count = count + words[i].length() + 1;
                sb.append(" ");
                sb.append(words[i]);
            } else {
                if (words[i-1].length() == count) {
                    while (count < L) {
                        sb.append(" ");
                        count++;
                    }
                } else {
                    while(count < L) {
                        for (int j = 1; j < sb.length(); j++) {
                            if (count == L) {
                                break;
                            }
                            if (sb.charAt(j-1) != ' ' && sb.charAt(j) == ' ') {
                                sb.insert(j++, " ");
                                count++;
                            }
                        }
                    }
                }
                res.add(sb.toString());
                sb.setLength(0);
                if (i < words.length) {
                    count = words[i].length();
                    sb.append(words[i]);
                }
            }
        }
        while (count < L) {
            sb.append(" ");
            count++;
        }
        res.add(sb.toString());
        return res;
    }
}

//3/29/2015
//more compact way of handling padding spaces
//also take advantage of some handy help functions like StringUtils
//Math.ceil

public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        int start = 0;
        int end = 0;
        int count = 0;
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        while (end < words.length) {
            String word = words[end];
            if (count != 0 && count + 1 + word.length() > L) {
                int insertIndex = 0;
                for (int i = start; i < Math.max(end - 1, start + 1); i++) {
                    insertIndex += words[i].length();
                    int paddingCount = (start + 1 == end) ? L - count : (int)Math.ceil(((double)(L - count)) / (end - 1 - i));
                    String padding = generatePadding(paddingCount);
                    //String padding = StringUtils.leftPadding("", paddingCount, ' ');
                    sb.insert(insertIndex, padding);
                    count += paddingCount;
                    insertIndex += paddingCount + 1;
                }
                res.add(sb.toString());
                count = 0;
                sb = new StringBuilder();
                start = end;
            }
            if (count == 0) {
                count += word.length();
                sb.append(word);
            } else {
                count += 1 + word.length();  
                sb.append(" " + word);
            }
            end++;
        }
        sb.append(generatePadding(L-count));
        res.add(sb.toString());
        return res;
    }
    public String generatePadding(int count) {
        String s = "";
        for (int i = 0; i < count; i++) {
            s += " ";
        }
        return s;
    }
}
