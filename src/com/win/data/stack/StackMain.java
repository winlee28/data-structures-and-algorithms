package com.win.data.stack;

import com.win.data.array.ArrayJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 使自定义的栈 来实现 LeetCode 20题 ：有效的括号
 */
public class StackMain {

    private static char char_1 = '{';
    private static char char_1_1 = '}';

    private static char char_2 = '[';
    private static char char_2_2 = ']';

    private static char char_3 = '(';
    private static char char_3_3 = ')';

    private static StackJava<Character> stackJava = new StackJava<>(new ArrayJava<Character>());

    public static void main(String[] args) {

        String s = "({})";
//        System.out.println(checkString(s));
        System.out.println(
                checkString2(s)
        );
    }


    /**
     * leetcode 官方解题思路
     *
     * @param str
     * @return
     */
    private static boolean checkString2(String str) {


        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            if (map.containsKey(c)) {
                char c1 = stackJava.isEmpty() ? '#' : stackJava.pop();
                if (c1 != map.get(c)) {
                    return false;
                }
            } else {
                stackJava.push(c);
            }
        }

        return stackJava.isEmpty();

    }

    /**
     * @param str
     * @return
     */
    private static boolean checkString(String str) {

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == char_1 || c == char_2 || c == char_3) {
                stackJava.push(c);
            } else {

                if (stackJava.isEmpty()) {
                    return false;
                }

                Character pop = stackJava.pop();

                if (c == char_1_1 && pop != char_1) {
                    return false;
                }
                if (c == char_2_2 && pop != char_2) {
                    return false;
                }
                if (c == char_3_3 && pop != char_3) {
                    return false;
                }
            }
        }

        return stackJava.isEmpty();

    }

}
