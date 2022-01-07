package com;

/**
 * Length of the longest substring without repeating characters Based on
 * https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 *
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class LongestSubstringUniqueChars {

    static final int NO_OF_CHARS = 256;

    public static void main(String[] args) {
        String str = "ABDEFGABEF";
        System.out.println("The input string is " + str);
        int maxLength = getLongestSubstring(str);
        System.out.println("Length of the longest non-repeating character substring = " + maxLength);
    }

    static Integer getLongestSubstring(String str) {
        int n = str.length();
        int currentLength = 1;
        int maxLength = 1;
        int previousIndex;
        int visited[] = new int[NO_OF_CHARS];

        //initialize with -1 to show not visited
        for (int i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }

        //store index of first characted in visited[]
        //index is ascii value of char
        visited[str.charAt(0)] = 0;

        //start at second char
        for (int i = 1; i < n; i++) {
            previousIndex = visited[str.charAt(i)];

            if (previousIndex == -1/*not visited*/ || i - currentLength > previousIndex) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = i - previousIndex;
            }
            //update index of current character
            visited[str.charAt(i)] = i;
        }
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }

        return maxLength;
    }
}
