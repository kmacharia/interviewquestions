package com;

/**
 * Program to find all permutations of a given String using recursion.
 * For example, given a String "XYZ", this program will print all 6 possible permutations of * input
 * e.g. XYZ, XZY, YXZ, YZX, ZXY, XYX
 * 
 * Based on https://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html
 * 
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class StringPermutations {
    public static void main(String[] args){
        permutation("1234");
    }
    
    public static void permutation(String input){
        permutation("", input);
    }
    
    private static void permutation(String perm, String word){
        if(word.isEmpty()){
            System.out.println(perm+word);
        } else {
            //TODO: How to handle this non-return type for JUnit tests
            for(int i=0; i<word.length(); i++){
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i+1, word.length()));
            }
        }
    }
}
