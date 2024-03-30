package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class P7_IntegerReverse {
    public static void main(String[] args) {
        int res = new P7_IntegerReverse().reverse(-120);
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * 由于32位整数的范围在 [-2^31, 2^31-1], 因此要对翻转的数越界的情况进行边界处理
     */
    public int reverse(int x) {
        List<Integer> numbers = new ArrayList();
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int temp = x % 10;
            x /= 10;
            result = result * 10 + temp;
        }
        return result;
    }
}
