package Algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Question:
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * Solution: 双指针法(滑动窗口法)可解答此题
 */
public class P3_NoRepeatMaxSubString {
    public static void main(String[] args) {
        int res = new P3_NoRepeatMaxSubString().lengthOfLongestSubstring("");
        System.out.println(res);
    }

    /**
     * 时间复杂度: O(n^2) 用哈希表可为 O(n)
     * 空间复杂度: O(n) 字符串不转换为数组, 使用 charAt() 方法提取对应索引的字母 可优化为 O(1)
     */
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

    /**
     * 时间复杂度: O(n), 实际迭代次数为 2n 即左右指针都遍历 n 次
     * 空间复杂度: O(∣Σ∣)，其中 Σ\SigmaΣ 表示字符集（即字符串中可以出现的字符），∣Σ∣|\Sigma|∣Σ∣ 表示字符集的大小。
     * 在本题中没有明确说明字符集，因此可以默认为所有 ASCII 码在 [0,128)[0, 128)[0,128) 内的字符，
     * 即 ∣Σ∣=128|\Sigma| = 128∣Σ∣=128。我们需要用到哈希集合来存储出现过的字符，而字符最多有 ∣Σ∣|\Sigma|∣Σ∣ 个，
     * 因此空间复杂度为 O(∣Σ∣)O(|\Sigma|)O(∣Σ∣)。
     */
    public int lengthOfLongestSubstring_official(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符 (进一步优化: 可以直接跳到重复字母所在的位置)
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
