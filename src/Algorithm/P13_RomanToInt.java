package Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Question:
 *
 * <p>
 * Solution:
 */
public class P13_RomanToInt {
    public static void main(String[] args) {
        String s = "abcdef";
        int res = new P13_RomanToInt().romanToInt(s);
        System.out.println(res);
    }

    /**
     * Method 1:
     * 时间复杂度:
     * 空间复杂度:
     */
    public int romanToInt(String s) {
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        Map<String, Integer> romansMap = new HashMap<>();
        int res = 0;
        int lastValue;
        for (int i = 0; i < romans.length; i++) {
            romansMap.put(romans[i], i);
        }

        lastValue = values[romansMap.get(s.substring(0, 1))];
        for (int i = 1; i < s.length(); i++) {
            int currentValue = values[romansMap.get(s.substring(i, i + 1))];
            if (currentValue > lastValue) {
                res -= lastValue;
            } else {
                res += lastValue;
            }
            lastValue = currentValue;
        }
        res += values[romansMap.get(s.substring(s.length() - 1))];

        return res;
    }
}
