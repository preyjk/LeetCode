package Algorithm;

public class P5_LongestPalindrome {
    public static void main(String[] args) {
//        String ans = new P5_LongestPalindrome().longestPalindrome("aattaa");
//        System.out.println(ans);
    }

    /**
     * 错误的实现，偶数个字符为中心的回文字符串无法正确返回
     * "aattaa" -> “aa”
     */
    public String longestPalindrome_wrong(String s) {
        int p1 = 0, p2 = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            int q1 = i, q2 = i;
            int compare_times = (i + 1) <= (length / 2) ? i : (length - i - 1);
            boolean flag = true;
            for (int j = 0; (j < compare_times) && flag; j++) {
                if (charArray[i - j - 1] == charArray[i + j + 1]) {
                    q1 = i - j - 1;
                    q2 = i + j + 1;
                } else {
                    flag = false;
                }
            }
            boolean flag2 = true;
            for (int k = 1; k < q2 - q1 + 1; k++) {
                if (charArray[q1 + k] != charArray[q1]) {
                    flag2 = false;
                }
            }
            if (flag2) {
                if (q1 - 1 >= 0 && charArray[q1 - 1] == charArray[q1]) {
                    q1 -= 1;
                }
                if (q2 + 1 < charArray.length && charArray[q2 + 1] == charArray[q1]) {
                    q2 += 1;
                }
            }
            if (q2 - q1 + 1 > p2 - p1 + 1) {
                p1 = q1;
                p2 = q2;
            }
        }
        return s.substring(p1, p2 + 1);
    }

    /**
     * Method 1: 动态规划
     */
    public String longestPalindrome_officialAns_1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    /**
     * Method 2: 中心扩展算法
     */

    /**
     * Method 3: Manacher 算法
     */
}

