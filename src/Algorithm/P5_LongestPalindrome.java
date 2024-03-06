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
    public String longestPalindrome(String s) {
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

    /**
     * Method 2: 中心扩展算法
     */

    /**
     * Method 3: Manacher 算法
     */
}

