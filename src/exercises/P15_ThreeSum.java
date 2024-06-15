package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Question:
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * Solution:
 */
public class P15_ThreeSum {

    /**
     * Method 1: 排序 + 双指针法
     * 时间复杂度:
     * 空间复杂度:
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int p = i + 1;
            int q = nums.length - 1;
            int target = -nums[i];
            while (p < q) {
                if (p > i + 1 && nums[p] == nums[p - 1]) {
                    p++;
                    continue;
                }
                if (nums[p] + nums[q] == target) {
                    res.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    p++;
                    q--;
                } else if (nums[p] + nums[q] > target) {
                    q--;
                } else if (nums[p] + nums[q] < target) {
                    p++;
                }
            }

        }
        return res;
    }

}
