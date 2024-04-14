package Algorithm;

/**
 * Question:
 * 给定一个长度为 n 的整数数组 height。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * <p>
 * Solution:
 * 核心是注意到两条线之间的储水体积大小取决于短板。
 */
public class P11_MaxArea {
    public static void main(String[] args) {

    }

    /**
     * Method 1:双指针法
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int shortIndex = height[left] < height[right] ? left : right;
            int area = (right - left) * height[shortIndex];
            if (max < area) {
                max = area;
            }
            if (shortIndex == left) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    /**
     *  灵活利用三元运算符，Math函数，数组索引自增运算符可以有效增加代码的可理解性。
     */
    public int maxArea_improveMaintainability(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = height[left] < height[right] ?
                    Math.max(max, (right - left) * height[left++]) :
                    Math.max(max, (right - left) * height[right--]);
        }
        return max;
    }
}
