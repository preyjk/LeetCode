package Algorithm;

/**
 * Question:
 * 判断一个数是否是回文数，若是则返回 true，不是则返回 false
 * <p>
 * Solution:
 * 双指针法
 */
public class P9_IsPalindrome {
    public static void main(String[] args) {
        new P9_IsPalindrome().isPalindrome(-15);
    }

    /**
     * Method 1: 数字转换字符串，再判断回文数
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        int p1 = 0, p2 = str.length() - 1;
        while (p1 < p2) {
            if (str.charAt(p1) != str.charAt(p2)) {
                return false;
            } else {
                p1++;
                p2--;
            }
        }
        return true;
    }
    /**
     * Method 2: / and % 取首尾数字比较法
     */

    /**
     * Method 3: 倒转后半段数字与前半段比较 (相比所有数字倒转后再比较 提升了时间效率而且不用额外防止超出最大数越界的情形)
     */
    public boolean isPalindrome_official(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

}
