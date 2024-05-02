package Algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Question:
 *
 * <p>
 * Solution:
 * ".*" "X*" ".X"
 */
public class P10_IsMatch {
    public static void main(String[] args) {
        // 正则表达式的基本功能: 匹配、查找、替换、分割
        // 匹配
        String text = "hello123";
        String patternString = "^[a-zA-Z]+\\d+$";
        // "." 匹配任意字符 and "*" 匹配任意次数，可以是0次
        text = "abc";
        patternString = ".*";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        if (matcher.matches()) {
            System.out.println("match.");
        } else {
            System.out.println("not match.");
        }
    }

    /**
     * Method 1:
     * 时间复杂度:
     * 空间复杂度:
     */
    public boolean isMatch_1(String s, String p) {
        return false;
    }
}
