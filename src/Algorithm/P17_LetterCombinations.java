package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Question:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * Solution:
 */
public class P17_LetterCombinations {
    public static void main(String[] args) {
        List<String> res = new P17_LetterCombinations().letterCombinations("23");
        System.out.println(res);
    }

    /**
     * Method 1:递归法 / 回溯法
     * 时间复杂度:
     * 空间复杂度:
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] letterList[] = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
        if (digits == "" || digits == null || digits.length() == 0) {
            return res;
        } else {
            getCombination("", digits, res, letterList, Integer.parseInt(String.valueOf(digits.charAt(0))) - 2, 0);
        }

        return res;
    }

    public void getCombination(String oneComb, String digits, List<String> res, String[] letterList[], int letterIndex, int letterLocation) {
        for (int i = 0; i < letterList[letterIndex].length; i++) {
            if (letterLocation < digits.length() - 1) {
                getCombination(oneComb + letterList[letterIndex][i], digits, res, letterList, Integer.parseInt(String.valueOf(digits.charAt(letterLocation + 1))) - 2, letterLocation + 1);
            } else {
                res.add(oneComb + letterList[letterIndex][i]);
            }
        }
    }

    /**
     * Method 2: 队列法
     * 时间复杂度:
     * 空间复杂度:
     */
}
