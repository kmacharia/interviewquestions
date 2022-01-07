package com;

import java.util.Stack;

/**
 *
 * Given a group of parenthesis, check whether they are balance or not
 *
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class BalancedParethesis {

    public static void main(String[] args) {
        char[] parenthesisArr = "[()]{}{[()()]()}".toCharArray();
        if (parenthesisArr.length % 2 == 1) {
            System.out.println("UNBALANCED parenthis. Odd character count");
        } else {
            Stack stack = new Stack();
            OUTER:
            for (int i = 0; i < parenthesisArr.length; i++) {
                switch (parenthesisArr[i]) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(parenthesisArr[i]);
                        break;
                    case ')':
                    case '}':
                    case ']':
                        if (stack.isEmpty()) {
                            System.out.println("UNBALANCED Parenthesis");
                        } else if (!isMatchingPair(parenthesisArr[i], (Character) stack.pop())) {
                            System.out.println("UNBALANCED Parenthesis");
                            break OUTER;
                        }

                        break;
                    default:
                        System.out.println("INVALID character");
                        break OUTER;
                }
            }
            if (stack.isEmpty()) {
                System.out.println("BALANCED Parenthesis");
            } else {
                System.out.println("UNBALANCED Parenthesis");
            }
        }
    }

    static boolean isMatchingPair(char closingParenthesis, char openingParenthesis) {
        if (openingParenthesis == '(' && closingParenthesis == ')') {
            return true;
        }
        if (openingParenthesis == '{' && closingParenthesis == '}') {
            return true;
        }
        if (openingParenthesis == '[' && closingParenthesis == ']') {
            return true;
        }
        return false;
    }

}
