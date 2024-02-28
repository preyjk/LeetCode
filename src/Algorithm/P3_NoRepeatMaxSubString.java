package Algorithm;

/**
 * Question:
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * Solution:
 */
public class P3_NoRepeatMaxSubString {
    public static void main(String[] args) {
        int res = new P3_NoRepeatMaxSubString().lengthOfLongestSubstring("");
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        int p1 = 0, p2 = 1;
        int max = 1;
        char[] charArray = s.toCharArray();
        while (p2 < charArray.length) {
            int temp = 0;
            for (int i = p1; i < p2; i++) {
                if (charArray[i] == charArray[p2]) {
                    p1 = i + 1;
                }
            }
            if (p1 != p2) {
                temp = p2 - p1 + 1;
                max = temp > max ? temp : max;
            }
            p2++;
        }
        if (s.isEmpty()) {
            max = 0;
        }
        return max;
    }
}
