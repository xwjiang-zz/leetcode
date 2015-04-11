//smartly construct the integer and roman arrays, do divide, do not get distracted by the special rules, they are no special!!!
public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] integer = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < integer.length; i++) {
            int times = num / integer[i];
            num -= times * integer[i];
            for (int j = 0; j < times; j++) {
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }
}
