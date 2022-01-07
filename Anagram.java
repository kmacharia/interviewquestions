package com;

import java.util.Arrays;

/**
 *
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class Anagram {
    public static void main(String args[]){
        char str1[] ="mate".toCharArray();
        char str2[] ="team".toCharArray();
        
        if(isAnagram(str1, str2)){
            System.out.println("Strings are anagrams");
        } else {
            System.out.println("Strings are NOT anagrams");
        }
    }
    
    static boolean isAnagram(char str1[], char str2[]){
        int n1 = str1.length;
        int n2 = str2.length;
        
        if(n1!=n2){
            return false;
        }
        
        Arrays.sort(str1);
        Arrays.sort(str2);
        
        for(int i=0; i<n1; i++){
            if(str1[i]!=str2[i]){
                return false;
            }
        }
        return true;
    }
}
