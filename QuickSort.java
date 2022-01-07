package com;

import java.util.Arrays;

/**
 * An algorithm to sort elements using Quick sort * Worst case complexity O(n2)
 *
 * Based on https://www.geeksforgeeks.org/quick-sort/
 *
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class QuickSort {

    public static void main(String args[]) {
        int arr[] = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        System.out.print("Given Array: ");
        System.out.println(Arrays.toString(arr));
        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, arr.length - 1);
        System.out.print("Sorted Array: ");
        System.out.println(Arrays.toString(arr));
    }

    void sort(int arr[], int low, int high) {
        if (low < high) {
            //pi is partitioning index, arr[pi] is at right index
            int pi = partition(arr, low, high);
            
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        int temp;
        for (int j = low; j < high; j++) {
            //if current element is smaller or equal to pivot
            if (arr[j] <= pivot) {
                i++;//no longer -1 on first iteration
                
                //swap. j & i same on first iteration
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap
        temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}
