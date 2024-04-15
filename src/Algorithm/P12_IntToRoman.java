package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Question:
 * 给你一个整数，将其转为罗马数字。罗马数字包含以下七种字符： I, V, X, L, C, D 和 M。
 * <p>
 * Solution:
 */
public class P12_IntToRoman {
    public static void main(String[] args) {
        String res = new P12_IntToRoman().intToRoman(58);
        System.out.println(res);
    }

    /**
     * Method 1:动态硬编码法
     * 时间复杂度:
     * 空间复杂度:
     * des: 不如硬编码法可维护性好
     */
    public String intToRoman(int num) {
        int digit = 0;
        int suffix = num % 10;
        List<String> res = new ArrayList();
        while (num > 0) {
            int currentNum = (int) (suffix * Math.pow(10, digit));
            switch (currentNum) {
                case 4:
                    res.add("IV");
                    break;
                case 9:
                    res.add("IX");
                    break;
                case 40:
                    res.add("XL");
                    break;
                case 90:
                    res.add("XC");
                    break;
                case 400:
                    res.add("CD");
                    break;
                case 900:
                    res.add("CM");
                    break;
                default:
                    if (currentNum < 5) {
                        for (int i = 0; i < suffix; i++) {
                            res.add("I");
                        }
                    } else if (currentNum < 10) {
                        for (int i = 0; i < suffix - 5; i++) {
                            res.add("I");
                        }
                        res.add("V");
                    } else if (currentNum < 50) {
                        for (int i = 0; i < suffix; i++) {
                            res.add("X");
                        }

                    } else if (currentNum < 100) {
                        for (int i = 0; i < suffix - 5; i++) {
                            res.add("X");
                        }
                        res.add("L");
                    } else if (currentNum < 500) {
                        for (int i = 0; i < suffix; i++) {
                            res.add("C");
                        }
                    } else if (currentNum < 1000) {
                        for (int i = 0; i < suffix - 5; i++) {
                            res.add("C");
                        }
                        res.add("D");
                    } else {
                        for (int i = 0; i < currentNum / 1000; i++) {
                            res.add("M");
                        }
                    }
            }
            num = num / 10;
            suffix = num % 10;
            digit++;
        }
        StringBuilder sb = new StringBuilder();
        for (String item : res) {
            sb.insert(0, item);
        }
        String resultString = sb.toString();
        return resultString;
    }

    /**
     * Method 2: 模拟
     * 每次减去罗马数字表示的value后添加一次罗马数字
     * 时间复杂度:
     * 空间复杂度:
     */

    /**
     * Method 3: 硬编码
     * 将个十百千...每位数字的每种情况编码，然后去匹配
     * 时间复杂度:
     * 空间复杂度:
     */
}
