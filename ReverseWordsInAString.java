public class Solution {
  public String reverseWords(String s) {
      StringBuilder sb = new StringBuilder();
        int currentInsertPoint = 0;
        int nextInsertPoint = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                while (i >= 0 && s.charAt(i) == ' ') {
                    i--;
                }
                if (i < 0) {
                    break;
                }
                if (nextInsertPoint > 0) {
                    sb.insert(nextInsertPoint, ' ');
                    nextInsertPoint++;
                    currentInsertPoint = nextInsertPoint;
                }
            }
            sb.insert(currentInsertPoint, s.charAt(i));
            nextInsertPoint++;
        }
        return sb.toString();
  }
}
