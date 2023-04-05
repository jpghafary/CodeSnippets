package com.novencia.societe;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedString {

    static boolean areBracketsBalanced(String str)
    {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<>();

        // Traversing the Expression
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == '{' || current == '(' || current == '[') {
                stack.push(current);
            }

            if (current == '}' || current == ')' || current == ']') {
                if (stack.isEmpty())
                    return false;

                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String ...args){
        boolean isBalanced;

        isBalanced = areBracketsBalanced("{[]([()]())[]}");
        System.out.println(isBalanced);

        isBalanced = areBracketsBalanced("{[]([(()]())[]}");
        System.out.println(isBalanced);

        isBalanced = areBracketsBalanced("(()");
        System.out.println(isBalanced);
    }
}
