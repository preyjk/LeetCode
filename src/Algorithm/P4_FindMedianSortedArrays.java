package Algorithm;

/**
 * Question:
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * Solution: 中位数相关题目
 */
public class P4_FindMedianSortedArrays {
    /**
     *  Method 1: 先归并再取中位数
     * 时间复杂度: O(m+n) PS: 一般我们说的时间复杂度都是指的 最坏情况的时间复杂度，而且时间复杂度默认忽略常系数和常数
     * 空间复杂度: O(m+n)
     */

    /**
     *  Method 2: 不归并数组，用两个指针分别指向两个数组的初始位置，因为中位数位置已知，因此每次移动较小数的指针即可, (m+n)/2 次迭代后找到答案
     * 时间复杂度: O(m+n)
     * 空间复杂度: O(1)
     */

    /**
     * Method 3: 因为归并后中位数所在的数组下标 K 是已知的，所以可以通过二分查找每次排除一半的 K 值， 因此时间复杂度对数化
     * 时间复杂度: O(log(m+n))
     * 空间复杂度: O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public double findMedianSortedArrays_kai(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 1) {
            return getKthElement_kai(nums1, nums2, (m + n) / 2 + 1);
        } else {
            return (getKthElement_kai(nums1, nums2, (m + n) / 2) + getKthElement_kai(nums1, nums2, (m + n) / 2 + 1)) / 2.0;
        }
    }

    public int getKthElement_kai(int[] nums1, int[] nums2, int k) {
        int p1 = 0, p2 = 0;

        while (true) {
            // bound
            if (p1 == nums1.length) {
                return nums2[p2 + k - 1];
            } else if (p2 == nums2.length) {
                return nums1[p1 + k - 1];
            } else if (k == 1) {
                return Math.min(nums1[p1], nums2[p2]);
            }

            int p1_new = k / 2 <= (nums1.length - p1) ? (k / 2 - 1 + p1) : (nums1.length - 1);
            int p2_new = k / 2 <= (nums2.length - p2) ? (k / 2 - 1 + p2) : (nums2.length - 1);
            if (nums1[p1_new] < nums2[p2_new]) {
                k -= p1_new - p1 + 1;
                p1 = p1_new + 1;

            } else {
                k -= p2_new - p2 + 1;
                p2 = p2_new + 1;
            }
        }
    }

    /**
     * Method 4: 划分数组法，进一步提高时间复杂度. 对较短数组可进行 m+1 种划分 ...
     * 时间复杂度: O(log min(m,n))
     * 空间复杂度: O(1)
     */
}
