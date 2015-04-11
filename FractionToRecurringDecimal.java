//1. numerator == 0
//2. interger to long is common way to deal with overflow when changing sign
//3. ^
//4. use a numerator map to record the position of the result digit corresponding to each occurance of numerator
//for StringBuilder, insert/append, it's better to use string directly. Otherwise, it's gonna be changed to string representation

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        long numeratorABS = Math.abs((long) numerator);
        long denominatorABS = Math.abs((long) denominator);
        if (!((numerator > 0)^(denominator > 0))) {
            return _fractionToDecimal(numeratorABS, denominatorABS);
        } else {
            return "-"+_fractionToDecimal(numeratorABS, denominatorABS);
        }
    }

    public String _fractionToDecimal(long numerator, long denominator) {
        StringBuilder sb = new StringBuilder();
        sb.insert(0, numerator/denominator);
        if (numerator % denominator == 0) {
            return sb.toString();
        }
        numerator = numerator % denominator;
        sb.append(".");
        int len = sb.length();
        Map<Long, Integer> numeratorMap = new HashMap<Long, Integer>();
        while (true) {
            if (numerator == 0) {
                return sb.toString();
            }
            if (numeratorMap.containsKey(numerator)) {
                sb.insert(numeratorMap.get(numerator), "(");
                sb.append(")");
                break;
            }
            numeratorMap.put(numerator, len++);
            sb.insert(sb.length(), numerator*10/denominator);
            numerator = numerator*10%denominator;
        }
        return sb.toString();
    }
}
