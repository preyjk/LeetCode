package Algorithm;

import java.util.Arrays;

/**
 * Question:
 *
 * <p>
 * Solution:
 */
public class P16_ThreeSumClosest {
    public static void main(String[] args) {
        int res = new P16_ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(res);
    }

    /**
     * Method 1: 排序 + 双指针
     * 时间复杂度:
     * 空间复杂度:
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        if (nums.length >= 3) {
            res = nums[0] + nums[1] + nums[2];
        } else {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int p = i + 1;
            int q = nums.length - 1;
            while (p < q) {
                if (p > i + 1 && nums[p] == nums[p - 1]) {
                    p++;
                    continue;
                }
                if (nums[i] + nums[p] + nums[q] == target) {
                    res = target;
                    return res;
                } else if (nums[i] + nums[p] + nums[q] > target) {
                    res = Math.abs(nums[i] + nums[p] + nums[q] - target) < Math.abs(res - target) ? nums[i] + nums[p] + nums[q] : res;
                    q--;
                } else if (nums[i] + nums[p] + nums[q] < target) {
                    res = Math.abs(nums[i] + nums[p] + nums[q] - target) < Math.abs(res - target) ? nums[i] + nums[p] + nums[q] : res;
                    p++;
                }
            }

        }
        return res;
    }
}
