package com;

/**
 * Given a string, remove all occurrences of a given character
 * 
 * Based on https://javarevisited.blogspot.com/2015/04/how-to-remove-given-character-from.html
 * 
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class RemoveCharFromString {
    
    public static String removeRecursively(String testString, char unwanted){
        int index = testString.indexOf(unwanted);
        if(index==-1){
            return testString;
        }
        return removeRecursively(testString.substring(0,index)+testString.substring(index+1), unwanted);
    }
}
