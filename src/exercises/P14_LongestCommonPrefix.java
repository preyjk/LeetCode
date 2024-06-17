package exercises;

/**
 * Question:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * <p>
 * Solution: LCP(S1…Sn)=LCP(LCP(LCP(S1,S2),S3),…Sn)
 */
public class P14_LongestCommonPrefix {
    /**
     * Method 1:
     * 时间复杂度:
     * 空间复杂度:
     */
    public String longestCommonPrefix(String[] strs) {
        int index_prefix = 0;
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs.length - 1; i++) {
            int j = 0;
            int index_prefix_temp = 0;
            if (strs[i].equals("") || strs[i + 1].equals("")) {
                return "";
            }
            while (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
                index_prefix_temp++;
                if (j < strs[i].length() - 1 && j < strs[i + 1].length() - 1) {
                    j++;
                } else {
                    break;
                }
            }
            if (i == 0) {
                index_prefix = index_prefix_temp;
            } else {
                if (index_prefix_temp < index_prefix) {
                    index_prefix = index_prefix_temp;
                }
            }
        }
        return strs[0].substring(0, index_prefix);
    }

    /**
     * official
     */
    public String longestCommonPrefix_official(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

}
