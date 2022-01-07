package com;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given a string, remove duplicate characters
 * 
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class RemoveDuplicatesString {
    public static void main (String[] args){
        char[] charArr = "HappyNewYear".toCharArray();
        Set<Character> charSet = new LinkedHashSet<>();
        for(char c : charArr){
            charSet.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(Character character : charSet){
            sb.append(character);
        }
        
        System.out.println(sb.toString());
    }
}
