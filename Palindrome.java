package com;

/**
 * Checks whether a given string is a palindrome or not.
 * Based on http://www.java67.com/2015/06/how-to-check-is-string-is-palindrome-in.html
 * 
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class Palindrome {
    public static void main(String args[]){
        String testcase = "racecar";
        System.out.println("Is " + testcase.toUpperCase() + " a palindrome: "+ isPalindrome(testcase));
    }
    
    static boolean isPalindrome(String testcase){
        String reverse = reverseString(testcase);
        System.out.println("Reversed String: "+ reverse);
        if(testcase.equals(reverse)){
            return true;
        }
        return false;
    }
    
    static String reverseString(String testcase){
        if(testcase == null || testcase.isEmpty()){
            return testcase;
        }
        //for substring, startIndex is inclusive, endIndex is exclusive
        return testcase.charAt(testcase.length()-1) + reverseString(testcase.substring(0, testcase.length()-1));
    }
}
