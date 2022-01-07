package com;

/**
 * Search index of an element in a sorted rotated array
 * 
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class SearchingRotatedArray {
    public static void main(String[] args){
        //assuming ascending order sorted array
        // Let us search 3 in below array 
       int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
       int n = arr.length; 
       int key = 6;
//       System.out.println("Index of the element is : " + pivotedBinarySearch(arr1, n, key));
        int i = search(arr, 0, n-1,key);
        if(i!=-1){
            System.out.println("Index of the element is : " + i);
        } else {
            System.out.println("Key not found");
        }
    }
    
    static int search(int arr[], int l, int h, int key){
        if(l>h){
            return -1;
        }
        int mid = (l+h)/2;
        if(arr[mid] == key){
            return mid;
        }
        //If arr[l...mid] is sorted
        if(arr[l] <= arr[mid]){
            if(key>=arr[l] && key<=arr[mid]){
                return search(arr, l, mid-1, key);
            }
            return search(arr, mid+1, h, key);
        }
        //If arr[l..mid] is not sorted,  
        //then arr[mid... r] must be sorted
        if(key>=arr[mid] && key <=arr[h]){
            return search(arr, mid+1, h, key);
        }
        return search(arr, l, mid-1, key);
    }
}
