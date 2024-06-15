package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question:
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）
 * <p>
 * Solution:
 */
public class P18_FourSum {
    public static void main(String[] args) {
        System.out.println(1000000000 + 1000000000 + 1000000000 + 1000000000);
    }

    /**
     * Method 1: 排序 + 多重循环 + 双指针
     * 时间复杂度:
     * 空间复杂度:
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int p = j + 1;
                int q = nums.length - 1;
                while (p < q) {
                    if (p > j + 1 && nums[p] == nums[p - 1]) {
                        p++;
                        continue;
                    }

                    if ((long) nums[i] + nums[j] + nums[p] + nums[q] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        p++;
                        q--;
                    } else if ((long) nums[i] + nums[j] + nums[p] + nums[q] > target) {
                        q--;
                    } else if ((long) nums[i] + nums[j] + nums[p] + nums[q] < target) {
                        p++;
                    }
                }
            }
        }
        return res;
    }
}
