package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class P6_ZConvert {
    public static void main(String[] args) {
        String res = new P6_ZConvert().convert("AB", 1);
        System.out.println(res);
    }

    /**
     * Method 1: 找到字符索引和行数的通项公式
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    public String convert(String s, int numRows) {
        char[] charArray = s.toCharArray();
        List<Character>[] listArray = new ArrayList[numRows];
        if (numRows < 2) {
            return s;
        }
        for (int i = 0; i < listArray.length; i++) {
            listArray[i] = new ArrayList();
        }
        for (int i = 0; i < charArray.length; i++) {
            int areaNum = numRows == 1 ? 0 : i / (2 * numRows - 2);
            int j = i - areaNum * (2 * numRows - 2);
            if (j < numRows) {
                listArray[j].add(charArray[i]);
            } else {
                listArray[2 * numRows - j - 2].add(charArray[i]);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < listArray.length; i++) {
            for (Character ch : listArray[i]) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    /**
     * Method 2: 利用行数递增然后递减的特性
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     */
    public String convert_easyPointer(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();

//        作者：Krahets
//        链接：https://leetcode.cn/problems/zigzag-conversion/solutions/21610/zzi-xing-bian-huan-by-jyd/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
