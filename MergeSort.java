package com;

import java.util.Arrays;

/**
 *An algorithm to sort elements using Merge sort 
 * Worst case complexity O(n log n)
 * 
 * Based on https://www.geeksforgeeks.org/merge-sort/
 * 
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class MergeSort {

    public static void main(String args[]) {
        int[] arr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        System.out.print("Given Array: ");
        System.out.println(Arrays.toString(arr));
        MergeSort ms = new MergeSort();
        ms.sort(arr, 0, arr.length - 1);
        System.out.print("Sorted Array: ");
        System.out.println(Arrays.toString(arr));
        
    }

    private void sort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            //Split and sort first and second halves
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // Merge the sorted halves 
            merge(arr, left, mid, right);
        }
    }

    private void merge(int arr[], int left, int mid, int right) {
        
        // Find sizes of two subarrays to be merged 
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        //Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }
          
        //Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
        //Initial index of merged subarry array 
        int k = left;
        //Merge the temp arrays
        while (i < n1 && j < n2){
            if (L[i] <= R[j]) {
                arr[k] = L[i]; 
                i++; 
            } else {
                arr[k] = R[j]; 
                j++; 
            }
            k++;
        }
        
        //Copy remaining elements of if any
        while (i < n1) {
            arr[k] = L[i]; 
            i++; 
            k++; 
        }
        while (j < n2) {
            arr[k] = R[j]; 
            j++; 
            k++;
        }    
    }
}
