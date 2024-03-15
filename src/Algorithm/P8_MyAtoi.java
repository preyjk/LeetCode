package Algorithm;

public class P8_MyAtoi {
    public static void main(String[] args) {
        int res = new P8_MyAtoi().myAtoi_regular("42");
        System.out.println(res);
    }

    /**
     * Method1: 常规解法
     */
    public int myAtoi_regular(String s) {
        int sign = 1;
        int res = 0;
        int start = 0;
        s = s.trim();
        // 判空
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 符号判定, 首字母非数字判定
        if (s.charAt(0) == '-') {
            sign = -1;
            start = 1;
        } else if (s.charAt(0) == '+') {
            start = 1;
        } else if (!Character.isDigit(s.charAt(0))) {
            return 0;
        }

        for (int i = start; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }

                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + sign * num;
            } else {
                break;
            }
        }
        return res;
    }

    /**
     * Method2: 自动机
     */
    public int myAtoi_ayto(String s) {
        return 0;
    }
}
