package Algorithm;

public class P70_ClimbStairs {
    /**
     * 动态规划: 递归实现
     * 时间复杂度: O(n^2) 函数调用次数指数级
     * 空间复杂度: O(n) 递归深度是n
     */
    public int climbStairs_1(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairs_1(n - 1) + climbStairs_1(n - 2);
    }

    /**
     * 动态规划: 循环实现
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int climbStairs_2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int p1 = 1;
        int p2 = 2;
        for (int i = 0; i < n - 2; i++) {
            int r = p1 + p2;
            p1 = p2;
            p2 = r;
        }
        return p2;
    }

    public int climbStairs_2_official(int n) {
        int p = 0, q = 0, r = 1; // 相当于指向连续三个位置答案的指针
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 快速幂法
     */

    /**
     * 通项公式法
     */
}
