package Algorithm;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Qusetion:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Solution:
 * 这种题一般都先从穷举法入手, 再去想优化的方法.
 */
public class P1_TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] results = new P1_TwoSum().twoSum_hashTable(nums, 9);
        System.out.println(results[0]);
        System.out.println(results[1]);
    }

    /**
     * Method 1: Brute Force
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * 时间复杂度高
     */
    public int[] twoSum_bruteForce(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * Method 2: 排序双指针法
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * 代码可维护性差
     */
    public int[] twoSum_sortDoublePointer(int[] nums, int target) {
        int[] copiedArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copiedArray);
        int i = 0, j = nums.length - 1;
        int sum;
        do {
            sum = copiedArray[i] + copiedArray[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            }
        } while (sum != target);
        int[] result = new int[2];
        result[0] = findIndex(nums, copiedArray[i], -1);
        result[1] = findIndex(nums, copiedArray[j], result[0]);
        return result;
    }

    public static int findIndex(int[] array, int valueToFind, int repeatIndex) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToFind) {
                if (i != repeatIndex) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Method 3: Hash Table
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * 推荐使用
     */
    public int[] twoSum_hashTable(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
