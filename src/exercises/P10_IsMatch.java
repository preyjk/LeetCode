package Algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Question:
 *
 * <p>
 * Solution:
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
     * Method 1: 双指针法，逐步判断
     * 时间复杂度:
     * 空间复杂度:
     */
    public boolean isMatch_1(String s, String p) {
        return false;
    }

    /**
     * Method 2: 动态规划 (from leetcode 官方解答)
     * 时间复杂度:
     * 空间复杂度:
     */
    class OfficialSolution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

            boolean[][] f = new boolean[m + 1][n + 1];
            f[0][0] = true;
            for (int i = 0; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        f[i][j] = f[i][j - 2];
                        if (matches(s, p, i, j - 1)) {
                            f[i][j] = f[i][j] || f[i - 1][j];
                        }
                    } else {
                        if (matches(s, p, i, j)) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
            return f[m][n];
        }

        public boolean matches(String s, String p, int i, int j) {
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }

    public boolean isMatch_2(String s, String p) {
        return false;
    }
}
